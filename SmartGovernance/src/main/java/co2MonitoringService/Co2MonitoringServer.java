package co2MonitoringService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.JOptionPane;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import co2MonitoringService.Co2MonitoringServiceGrpc.Co2MonitoringServiceImplBase;
public class Co2MonitoringServer extends Co2MonitoringServiceImplBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Co2MonitoringServer co2MonitorServer = new Co2MonitoringServer();

		Properties prop = co2MonitorServer.getProperties();

		co2MonitorServer.registerService(prop);

		int port = Integer.parseInt( prop.getProperty("monitoring_service_port")); //#50063

		try {
			Server server = ServerBuilder.forPort(port)
					.addService(co2MonitorServer)
					.build()
					.start();

			System.out.println(" Co2 Server started listening on port: " + port);
			System.out.println("----------------------------------------------------------\n");

			server.awaitTermination();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private Properties getProperties() {
		Properties prop = null;

		//Define the input properties path
		try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/co2Monitoring.properties"))){

			prop = new Properties();

			//load a properties file
			prop.load(input);

			//get the properties value and print it out
			System.out.println(" Co2 Monitoring Service properties ...");
			System.out.println("\t service_type: " +prop.getProperty("monitoring_service_type"));
			System.out.println("\t service_name: " + prop.getProperty("monitoring_service_name"));
			System.out.println("\t service_description: " + prop.getProperty("monitoring_service_description"));
			System.out.println("\t service_port: " + prop.getProperty("monitoring_service_port"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return prop;
	}

	private void registerService(Properties prop) {
		try {
			//Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			/*
			 * Setting service information - prepare parameters for creating the ServiceInfo
			 */

			//registering  http server
			String monitoring_service_type = prop.getProperty("monitoring_service_type");
			String monitoring_service_name = prop.getProperty("monitoring_service_name"); //"co2monitoring_service";
			int monitoring_service_port = Integer.parseInt( prop.getProperty("monitoring_service_port")); //#50053;
			String monitoring_service_description_properties = prop.getProperty("monitoring_service_description");

			//Register a service
			ServiceInfo serviceInfo = ServiceInfo.create(monitoring_service_type,
					monitoring_service_name,
					monitoring_service_port,
					monitoring_service_description_properties);

			jmdns.registerService(serviceInfo);

			System.out.printf(" Registering service with type: %s\n and name: %s \n", monitoring_service_type, monitoring_service_name);

			//Wait a bit
			Thread.sleep(1200);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//unary rpc 
	@Override
	public void powerSwitch(PowerRequest request,
							StreamObserver<PowerResponse> responseObserver) {
		System.out.println("-------------- Unary --------------");

		Boolean check= request.getPower();

		if (check==true) {
			System.out.println("Switch is turning ON ");
		}
		else {
			System.out.println("Switch is turning OFF ");

		}
		// Send a response with value back
		PowerResponse responce=PowerResponse.newBuilder().setPower(check).build();
		responseObserver.onNext(responce);

		// here where the server proto files has completed the process
		responseObserver.onCompleted();

	}

	public StreamObserver<Co2Request> co2Emission(StreamObserver<Co2Response> responseObserver){
		return new StreamObserver<Co2Request>() {

			@Override
			public void onNext(Co2Request value) {

				System.out.println("Receiving Co2 Emission request for: ");
				System.out.println("Carbon Emission value: " + value.getCarbon() + "/g/km");
				String result = "";

				//Band A1
				if (value.getCarbon() >= 0 && value.getCarbon() <= 80 ){
					result = ("Band type is: A1, and the cost is €170 annual, 48 Quarterly");
				}

				else if (value.getCarbon() > 80 && value.getCarbon() <= 100 ){
					result = ("Band type is: A2, and the cost is €180 annual, €50 Quarterly");
				}
				else if (value.getCarbon() > 100 && value.getCarbon() <= 110 ){
					result = ("Band type is: A3, and the cost is €190 annual, €53 Quarterly");
				}
				else if (value.getCarbon() > 110 && value.getCarbon() <= 120 ){
					result = ("Band type is: A4, and the cost is €200 annual, €56 Quarterly");
				}
				else if (value.getCarbon() > 120 && value.getCarbon() <= 130 ){
					result = ("Band type is: B1, and the cost is €270 annual, €76 Quarterly");
				}
				else if (value.getCarbon() > 130 && value.getCarbon() <= 140 ){
					result = ("Band type is: B2, and the cost is €280 annual, €79 Quarterly");
				}
				else if (value.getCarbon() > 140 && value.getCarbon() <= 155 ){
					result = ("Band type is: C, and the cost is €390 annual, €110 Quarterly");
				}
				else if (value.getCarbon() > 155 && value.getCarbon() <= 170 ){
					result = ("Band type is: D, and the cost is €570 annual, €161 Quarterly");
				}
				else if (value.getCarbon() > 170 && value.getCarbon() <= 190 ){
					result = ("Band type is: E, and the cost is €750 annual, €211 Quarterly");
				}
				else if (value.getCarbon() > 190 && value.getCarbon() <= 255 ){
					result = ("Band type is: F, and the cost is €1200 annual, €339 Quarterly");
				}
				else if (value.getCarbon() > 225 ){
					result = ("Band type is: G, and the cost is €2350 annual, €663 Quarterly");
				}

				//Wrong number of has been entered
				else {
					JOptionPane.showMessageDialog(null, "Wrong number entered");
				}

				Co2Response reply = Co2Response.newBuilder().setResult(result).build();
				responseObserver.onNext(reply);

			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {

				System.out.println("CO2 Emission request completed.");
				System.out.println("------------------------------------------\n");
				responseObserver.onCompleted();
			}


		};


	}


}
