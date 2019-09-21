package concurrent;

public class VehicleClassifier implements Runnable{
	Vehicle prev;
	
	public void classify(Vehicle v) {
		System.out.println("Vehicle " + v.id + " is a " + v.type );
		prev = v;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(prev != Main.vehicle)
				classify(Main.vehicle);
			
		}
		
	}
}
