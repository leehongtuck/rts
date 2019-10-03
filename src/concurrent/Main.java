package concurrent;

public class Main {
	static volatile Vehicle vehicle;
	
	public static void main(String[] args) throws InterruptedException {	
		Thread t1, t2, t3;
		t1 = new Thread(new VehicleClassifier());
		t2 = new Thread(new NumberPlateReader());
		t3 = new Thread(new SpeedDetector());
		t1.start();
		t2.start();
		t3.start();
		
		Thread thrVg = new Thread(new VehicleGenerator());
		thrVg.start();
	}
}

