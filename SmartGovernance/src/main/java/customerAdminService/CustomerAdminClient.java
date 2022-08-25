package customerAdminService;

import java.util.Iterator;

import customerAdminService.CustomerAdminServiceGrpc.CustomerAdminServiceBlockingStub;
import customerAdminService.CustomerAdminServiceGrpc.CustomerAdminServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class CustomerAdminClient {


	private static CustomerAdminServiceBlockingStub adminBlockingStub;
	private static CustomerAdminServiceStub adminAsyncStub;

	public static void main(String[] args) {
	
		ManagedChannel adminChannel = ManagedChannelBuilder.
							forAddress("localhost", 50072)
							.usePlaintext()
							.build();
		
		//stubs -- generate from proto
		adminBlockingStub = CustomerAdminServiceGrpc.newBlockingStub(adminChannel);
		adminAsyncStub = CustomerAdminServiceGrpc.newStub(adminChannel);
		
		registerCustomer();
		displayCustomers();
		calculatePrice();
	}	
	
	//Client Streaming
	//Register Customer tax price service
	public static void registerCustomer() {
		
		StreamObserver<RegisterResponse> responseObserver = new StreamObserver<RegisterResponse>() {

			@Override
			public void onNext(RegisterResponse value) {
				System.out.println("Server responded; Customer registered with,\n" + value.getResult() + "\n");	
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();				
			}

			@Override
			public void onCompleted() {
				System.out.println("Customer registration completed.");	
				System.out.println("-------------------------------\n");				
			}			
		};
		
		StreamObserver<RegisterRequest> requestObserver = adminAsyncStub.registerCustomers(responseObserver);
		requestObserver.onNext(RegisterRequest.newBuilder()
											.setName("Giulio Conte")
											.setTaxNo("5805")
											.setPaymentType("Annual")
											.build());	
				
		//Mark the end of requests
		requestObserver.onCompleted();
		
		try {
			//Wait a bit
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	////Server Streaming
	////Display Customer List
	public static void displayCustomers() {
		//creating request to send the Customer list
		DisplayRequest request = DisplayRequest.newBuilder().setCustomerList("").build();		
		
		
		// try catch, error handling
		try {
			// while the server is still responding/ sending data back, keep printing data
			Iterator<DisplayResponse> responses = adminBlockingStub.displayCustomers(request);
			
			System.out.println("Server responded: displaying Customer list,\n");
			
			while (responses.hasNext()) {
				DisplayResponse customerList = responses.next();				
				System.out.println(customerList.getAllCustomers() + "\n");
			}	
			
			System.out.println("Customer list has been completed.");
			System.out.println("---------------------------------------------------\n");
			
		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}
	}
	////Unary Call
	////Calculate Customer tax price
	public static void calculatePrice () {
					
		int numVehicle = (int) 1;
		String customerName = "Laura Smit";
			
		CalculateRequest request = CalculateRequest.newBuilder().setCustomerName(customerName).setNumberVehicle(numVehicle).build();
		CalculateResponse response = adminBlockingStub.calculatePrice(request);
			
		System.out.println("Server responded; Customer tax price calculated,\n" + response.getMessage());
		System.out.println("Calculation of Customer Tax completed.");	
		System.out.println("-----------------------------------------------------------\n");			
	}
	
}
