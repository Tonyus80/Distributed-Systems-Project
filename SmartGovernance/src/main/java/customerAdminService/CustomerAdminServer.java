package customerAdminService;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import java.io.InputStream;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import customerAdminService.CalculateRequest.VehicleType;
import customerAdminService.CustomerAdminServiceGrpc.CustomerAdminServiceImplBase;


public class CustomerAdminServer extends CustomerAdminServiceImplBase{

	private StreamObserver<RegisterResponse> responseObserver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
CustomerAdminServer custAdminService = new CustomerAdminServer();
		
		Properties adminProp = custAdminService.getAdminProperties();
		
		custAdminService.registeringCustomerByAdminService(adminProp);
		
		int adminPort = Integer.parseInt( adminProp.getProperty("administration_service_port")); //
		
		try {
			Server adminServer = ServerBuilder.forPort(adminPort)
											.addService(custAdminService)
											.build()
											.start();
			
			System.out.println(" Customer Admin Server started listening on port: " + adminPort);
			System.out.println("--------------------------------------------------------------\n");
			
			adminServer.awaitTermination();
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private Properties getAdminProperties() {
		
		Properties adminProp = null;
		
		//Define the input properties path
		try (InputStream adminInput = Files.newInputStream(Paths.get("src/main/resources/customerAdmin.properties"))){
			
			adminProp = new Properties();
			
			//load a properties file
			adminProp.load(adminInput);		
			
			//get the properties value and print it out
			System.out.println(" Customer Admin Service properties ...");
			System.out.println("\t service_type: " + adminProp.getProperty("administration_service_type"));
			System.out.println("\t service_name: " + adminProp.getProperty("administration_service_name"));					
			System.out.println("\t service_description: " + adminProp.getProperty("administration_service_description"));
			System.out.println("\t service_port: " + adminProp.getProperty("administration_service_port"));
											
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return adminProp;
	}	
	
	
public void registeringCustomerByAdminService(Properties adminProp) {		
		
		try {
			//Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			/*
			 * Setting service information - prepare parameters for creating the ServiceInfo
			 */
			
			//Assume that there is registering an http server
			String administration_service_type = adminProp.getProperty("administration_service_type");
			String administration_service_name = adminProp.getProperty("administration_service_name");
			int administration_service_port = Integer.parseInt( adminProp.getProperty("administration_service_port")); //port example #50072;
			String administration_service_description_properties = adminProp.getProperty("administration_service_description");
			
			//Register a service			
			ServiceInfo adminServiceInfo = ServiceInfo.create(administration_service_type, 
															administration_service_name, 
															administration_service_port, 
															administration_service_description_properties);
			
			jmdns.registerService(adminServiceInfo);
			
			System.out.printf(" Registering service with type: %s\n and name: %s \n", administration_service_type, administration_service_name);
			
			////Wait a second
			Thread.sleep(1000);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
		
	////Client streaming
	////Customer Registration 
	public StreamObserver<RegisterRequest> registerCustomers(StreamObserver<RegisterResponse> responseObserver){
		this.responseObserver = responseObserver;///test

		return new StreamObserver<RegisterRequest>() {

			@Override
			public void onNext(RegisterRequest value) {
				System.out.println("Receiving Customer registration request,\nCustomer Name: " + value.getName()
																			+ ", Tax No.: " + value.getTaxNo()
																			+ ", Payment Type: " + value.getPaymentType()
																			+ "\n");
				
				String result = ("Customer Name: " + value.getName() 
												+ ", Tax No.: " + value.getTaxNo()
												+ ", Payment Type:: " + value.getPaymentType());
				
				RegisterResponse reply = RegisterResponse.newBuilder().setResult(result).build();
				responseObserver.onNext(reply);				
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();				
			}

			@Override
			public void onCompleted() {
				System.out.println("Customer registering request completed.");
				System.out.println("--------------------------------------\n");
				
				//completed too
				responseObserver.onCompleted();				
			}			
		};
	}
	
	////Server streaming
	////Show list of Customer
	public void displayCustomers(DisplayRequest request, StreamObserver<DisplayResponse> responseObserver) {
		
		System.out.print("Receiving Customer list display request,\n\n" + request.getCustomerList());

		ArrayList<String> customerList = new ArrayList<String>();
		customerList.add("Customer Name: Aron Edge, Tax No.: 3545, Payment Type: annual");
		customerList.add("Customer Name: Laura Smit, Tax No.: 3271, Payment Type:: monthly");
		customerList.add("Customer Name: Patrick Summer, Tax No.: 6987, Payment Type: quarterly");
		customerList.add("Customer Name: Paul Suleiman, Tax No.: 1737, Payment Type: quarterly");
		customerList.add("Customer Name: Winnie Gala, Tax No.: 2122, Payment Type: annual");
		customerList.add("Customer Name: Gabriel Murphy, Tax No.: 7048, Payment Type: monthly");

		for (int i = 0; i <  customerList.size(); i++) {

			DisplayResponse reply = DisplayResponse.newBuilder().setAllCustomers(customerList.get(i)).build();
			
			responseObserver.onNext(reply);
			
			System.out.println("Display details of Customer: " + i + "\n" + customerList.set(i, null) + "\n");			
			
			// error handling
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Customer listing request completed.");
		System.out.println("--------------------------------\n");
		responseObserver.onCompleted();			
	}	
	
	//Unary call
	//Calculate Vehicle price
	public void calculatePrice(CalculateRequest request, StreamObserver<CalculateResponse> responseObserver) {		
		
		System.out.println("Receiving Customer Vehicle Type, requesting price calculation for,\nCustomer Name: " + request.getCustomerName()
																				+ ", has: " + request.getNumberVehicle() 
																				+" vehicle, with fuel type: " + request.getVehicleType() + " .....\n");
		
		@SuppressWarnings("unused")
		String customerName = "";
		float pricePerVehicle = (float) 0.00;
		float totalPrice = (float) 0.00;
		String message = "The total price of vehicle for customer:\n " + request.getCustomerName() + 
															", for: "+ request.getNumberVehicle() + 
															" vehicle, type: " + request.getVehicleType() + " is: € ";
		
		
		String result = "";		
		
		if (request.getVehicleType()==VehicleType.DIESEL) {	
			pricePerVehicle = (float) 100.00;
			totalPrice = request.getNumberVehicle() * (float) pricePerVehicle;
			result = message + totalPrice + "\n";			
		}
		
		else if (request.getVehicleType()==VehicleType.ELECTRIC) {
			pricePerVehicle = (float) 200.00;
			totalPrice = request.getNumberVehicle() * (float) pricePerVehicle;
			result = message + totalPrice + "\n";			
		}
		
		else if (request.getVehicleType()==VehicleType.PETROL) {
			
			pricePerVehicle = (float) 300.00;
			totalPrice = request.getNumberVehicle() * (float) pricePerVehicle;
			result = message + totalPrice + "\n";
		}
		
		else {
			result = "type of Vehicle not found";
		}
		
		CalculateResponse reply = CalculateResponse.newBuilder().setMessage(result).build();
		responseObserver.onNext(reply);			
		responseObserver.onCompleted();		
		System.out.println("Customer Vehicle price calculation request completed.");
		System.out.println("-----------------------------------------------------------------------\n");
	}
}

	
