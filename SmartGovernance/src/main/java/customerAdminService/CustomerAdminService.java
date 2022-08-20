package customerAdminService;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
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


public class CustomerAdminService extends  CustomerAdminServiceImplBase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
CustomerAdminService custAdminService = new CustomerAdminService();
		
		Properties adminProp = custAdminService.getAdminProperties();
		
		custAdminService.registeringCustomerByAdminService(adminProp);
		
		int adminPort = Integer.valueOf( adminProp.getProperty("administration_service_port")); //#50052
		
		try {
			Server adminServer = ServerBuilder.forPort(adminPort)
											.addService(custAdminService)
											.build()
											.start();
			
			System.out.println(" Customer Admin Server started listening on port: " + adminPort);
			System.out.println("--------------------------------------------------------------\n");
			
			adminServer.awaitTermination();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	private Properties getAdminProperties() {
		
		Properties adminProp = null;
		
		//Define the input properties path
		try (InputStream adminInput = new FileInputStream("src/main/resources/patient_administration.properties")){
			
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
			String administration_service_type = adminProp.getProperty("administration_service_type"); //"_administration._tcp.local.";
			String administration_service_name = adminProp.getProperty("administration_service_name"); //"customer_administration_service";
			int administration_service_port = Integer.valueOf( adminProp.getProperty("administration_service_port")); //#50052;
			String administration_service_description_properties = adminProp.getProperty("administration_service_description"); //"path=index.html";
			
			//Register a service			
			ServiceInfo adminServiceInfo = ServiceInfo.create(administration_service_type, 
															administration_service_name, 
															administration_service_port, 
															administration_service_description_properties);
			
			jmdns.registerService(adminServiceInfo);
			
			System.out.printf(" Registering service with type: %s\n and name: %s \n", administration_service_type, administration_service_name);
			
			////Wait a second
			Thread.sleep(1000);
			
			//System.out.println("Ready to unregister services");
			
			//Unregister all services			
			//jmdns.unregisterAllServices();
			//jmdns.unregisterService(adminServiceInfo);
			
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
	public StreamObserver<RegisterRequest> registerCustomer(StreamObserver<RegisterResponse> responseObserver){
		
		return new StreamObserver<RegisterRequest>() {

			@Override
			public void onNext(RegisterRequest value) {
				System.out.println("Receiving Customer registration request,\nCustomer Name: " + value.getName()
																			+ ", Age: " + value.getAge()
																			+ ", Gender: " + value.getGender() 
																			+ "\n");
				
				String result = ("Customer Name: " + value.getName() 
												+ ", Age: " + value.getAge() 
												+ ", Gender: " + value.getGender());
				
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
	public void displayCustomer(DisplayRequest request, StreamObserver<DisplayResponse> responseObserver) {
		
		System.out.print("Receiving Customer list display request,\n\n" + request.getCustomerList());

		ArrayList<String> customerList = new ArrayList<String>();
		customerList.add("Customer Name: Gerry Boyle, Age: 51, Gender: male");
		customerList.add("Customer Name: Laura Smit, Age: 31, Gender: female");		
		customerList.add("Customer Name: Patrick Summer, Age: 67, Gender: male");
		customerList.add("Customer Name: Winnie Gala, Age: 22, Gender: female");
		customerList.add("Customer Name: Gabriel Murphy, Age: 78, Gender: male");		

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
		
		System.out.println("Receiving Customer Vehicle Type price calculation request for,\nCustomer Name: " + request.getCustomerName()
																				+ ", for: " + request.getNumberVehicle() 
																				+" days, in a: " + request.getVehicleType() + " room.\n");
		
		@SuppressWarnings("unused")
		String customerName = "";
		float pricePerVehicle = (float) 0.00;
		float totalPrice = (float) 0.00;
		String message = "The total vehicle price for the customer:\n " + request.getCustomerName() + 
															", for: "+ request.getNumberVehicle() + 
															" days, in a: " + request.getVehicleType() + " vehicle is: € ";
		
		
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
			
			pricePerVehicle = (float) 500.00;
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
		System.out.println("----------------------------------------------------------\n");		
	}
}

	
