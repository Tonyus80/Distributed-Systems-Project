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
				forAddress("localhost", 50053)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = Co2MonitoringServiceGrpc.newBlockingStub(channel);
		asyncStub = Co2MonitoringServiceGrpc.newStub(channel);


		monitoringDeviceOnOff();
		co2Emission();

	}

	private static void co2Emission() {

		StreamObserver<Co2Response> responseObserver = new StreamObserver<Co2Response>(){

			@Override
			public void onNext(Co2Response value) {
				System.out.println("Server response: The result of CO2 Emission is: " + value.getResult());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("CO2 Emission check completed.");
				System.out.println("-------------------------------\n");
			}
		};


	}

	private static void monitoringDeviceOnOff() {
		String status = "On";

		//sent the request
		DeviceRequest request = DeviceRequest.newBuilder().setText(status).build();

		//check the response
		DeviceResponse response = blockingStub.monitoringDeviceOnOff(request);

		System.out.println("Server responded; The Monitoring Device has been turned: " + response.getValue());
		System.out.println("Changing the status of the monitoring device has been completed.");
		System.out.println("----------------------------------------------------------------\n");
	}

	//Bi-Directional
	//Co2Emission monitoring
	public static void Co2Emission() {

		StreamObserver<Co2Response> responseObserver = new StreamObserver<Co2Response>(){

			@Override
			public void onNext(Co2Response value) {
				System.out.println("Server responded; The result of blood checking is: " + value.getResult());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("Blood Pressure check completed.");
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
