package sequential;

public class SpeedDetector {
	
	public void detect(Vehicle v) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Vehicle " + v.id + " is moving at a speed of " + v.speed + "km/h" );
		if(v.speed == 0) {
			System.out.println("Vehicle " + v.id + " , a " + v.type + " has broken down!");
			new AuthoritiesNotifier().run(v);
			new GpsNotifier().run(v);
		}
	}
}
