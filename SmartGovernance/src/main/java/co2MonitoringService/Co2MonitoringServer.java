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
//public class Co2MonitoringServer extends Co2MonitoringServiceGrpc.Co2MonitoringServiceImplBase {
public class Co2MonitoringServer extends Co2MonitoringServiceImplBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Co2MonitoringServer co2MonitorServer = new Co2MonitoringServer();
		
		Properties prop = co2MonitorServer.getProperties();
		
		co2MonitorServer.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("monitoring_service_port")); //#50053
		
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

			//System.out.println("Ready to unregister services");

			//Unregister all services
			//jmdns.unregisterAllServices();
			//jmdns.unregisterService(serviceInfo);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Unary call
	//TURN ON/OFF Monitoring Device
	@Override
	public void monitoringDeviceOnOff(DeviceRequest request, StreamObserver<DeviceResponse> responseObserver) {

		System.out.println("Receiving Monitoring Device status change request: " + request.getText());

		DeviceResponse reply = DeviceResponse.newBuilder().setValue(request.getText()).build();

		responseObserver.onNext(reply);
		responseObserver.onCompleted();

		System.out.println("Monitoring Device status changing request completed.");
		System.out.println("----------------------------------------------------\n");
	}

	public StreamObserver<Co2Request> co2Emission(StreamObserver<Co2Response> responseObserver){
		return new StreamObserver<Co2Request>() {

			@Override
			public void onNext(Co2Request value) {

				System.out.println("Receiving Co2 Emission request for: ");
				System.out.println("Carbon Emission value: " + value.getCarbon() + "/mmHg");
				System.out.println("Oxygen Emission value " + value.getOxygen() + "/mmHg");

				String result = "";


			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {

				System.out.println("CO2 Emission request completed.");
				System.out.println("------------------------------------------\n");

				//completed too
				responseObserver.onCompleted();
			}


		};


	}


}
