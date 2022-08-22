package co2MonitoringService;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import co2MonitoringService.Co2MonitoringServiceGrpc.Co2MonitoringServiceBlockingStub;
import co2MonitoringService.Co2MonitoringServiceGrpc.Co2MonitoringServiceStub;
public class Co2MonitoringClient {

	private static Co2MonitoringServiceBlockingStub blockingStub;
	private static Co2MonitoringServiceStub asyncStub;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ManagedChannel channel = ManagedChannelBuilder.
				forAddress("localhost", 50063)
				.usePlaintext()
				.build();

		//stubs from proto
		blockingStub = Co2MonitoringServiceGrpc.newBlockingStub(channel);
		asyncStub = Co2MonitoringServiceGrpc.newStub(channel);


		monitoringDeviceOnOff();
		powerSwitch();
		co2Emission();

	}
	
	// preparing the message request
			private static void powerSwitch() {
			// TODO Auto-generated method stub
				System.out.println("-------------- Unary --------------");

				
				boolean input=false;
				System.out.println("Want to turned ON Auto-renewal? "+input);
				
				
				PowerRequest request= PowerRequest.newBuilder().setPower(input).build();
				
				// sending the message request & also receiving response 
				PowerResponse response=	blockingStub.powerSwitch(request);
				
				//priniting response from server
				
				if(response.getPower()==true) {
					System.out.println("Server response: Auto-renewal turned ON ");
				}
				else {
					System.out.println("Server response: Auto-renewal turned OFF ");
				}
		}
			
	
	
	private static void monitoringDeviceOnOff() {
		String devStatus = "On";

		//sent the request
		DeviceRequest request = DeviceRequest.newBuilder().setText(devStatus).build();

		//check the response
		DeviceResponse response = blockingStub.monitoringDeviceOnOff(request);

		System.out.println("Server responded; The Monitoring Device has been turned: " + response.getValue());
		System.out.println("The status of the monitoring device has been completed.");
		System.out.println("----------------------------------------------------------------\n");
	}

	//Bi-Directional
	//Co2Emission monitoring
	public static void co2Emission() {

		StreamObserver<Co2Response> responseObserver = new StreamObserver<Co2Response>(){

			@Override
			public void onNext(Co2Response value) {
				System.out.println("Server responded: The result of Co2 Emission is: " + value.getResult());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("Co2 Emission check completed.");
				System.out.println("-------------------------------\n");
			}
		};

		StreamObserver<Co2Request> requestObserver = asyncStub.co2Emission(responseObserver);

		requestObserver.onNext(Co2Request.newBuilder().setCarbon(110).setOxygen(70).build());

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

}
