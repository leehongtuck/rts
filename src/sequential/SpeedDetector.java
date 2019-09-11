package sequential;

public class SpeedDetector {
	
	public void run(Vehicle v) {
		System.out.println("Vehicle " + v.id + " is moving at a speed of " + v.speed + "km/h" );
		if(v.speed == 0) {
			System.out.println("gg broke down");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
