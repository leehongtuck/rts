package sequential;

public class Test {
	private static int vehicleCount = 1;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("testing");
	
		SpeedDetector sd = new SpeedDetector();
		VehicleClassifier vc = new VehicleClassifier();
		NumberPlateReader npr = new NumberPlateReader();
		
		VehicleBrokeDown vbd = new VehicleBrokeDown();
		Thread thrVbd = new Thread(vbd);
		thrVbd.start();
		
		while(true) {
			Vehicle v = new Vehicle(vehicleCount++);
			vbd.setVehicle(v);
			vc.classify(v);
			npr.run(v);
			sd.detect(v);
		}
	}	
}

class VehicleBrokeDown implements Runnable {
	Vehicle v;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(v != null) {
				if(Math.random() < 0.4) {
					v.speed = 0;
					v = null;
					
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
		}
	}
	
	public void setVehicle(Vehicle v) {
		this.v = v;
		notify();
	}
	
	public void removeVehicle(Vehicle v) {
		v = null;
	}
	
	
	
	
	
}
