package sequential;

public class SpeedDetector {
	
	public void detect(Vehicle v) {
		System.out.println("Vehicle " + v.id + " is moving at a speed of " + v.speed + "km/h" );
		if(v.speed == 0) {
			System.out.println("Vehicle " + v.id + " , a " + v.type + " has broken down!");
			
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
