package concurrent;

import java.util.Date;

import sequential.Vehicle;
import sequential.VehicleBreakdown;

public class Test {
	public static long difference; 
	
	public static void main(String[] args) throws InterruptedException {
		int vehicleCount = 1;
		
		VehicleBreakdown vbd = new VehicleBreakdown();
		Thread thrVbd = new Thread(vbd);
		thrVbd.start();
		Thread t1, t2, t3;
		
		while(true) {
			difference = new Date().getTime();
			Vehicle v = new Vehicle(vehicleCount++);
			vbd.setVehicle(v);
			t1 = new Thread(new VehicleClassifierThread(v));
			t2 = new Thread(new NumberPlateReaderThread(v));
			t3 = new Thread(new SpeedDetectorThread(v));
			t1.start();
			t2.start();
			t3.start();
			
			t1.join();
			t2.join();
			t3.join();
		}
	}
}

