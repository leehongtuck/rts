package concurrent;

public class SpeedDetector implements Runnable {
	Vehicle prev;
	
	public void detect(Vehicle v) {
		System.out.println("Vehicle " + v.id + " is moving at a speed of " + v.speed + "km/h" );
		prev = v;
		if(v.speed == 0) {
			System.out.println("Vehicle " + v.id + " , a " + v.type + " has broken down!");
			new Thread(new AuthoritiesNotifier(v)).start();;
			new Thread(new GpsNotifier(v)).start();
		}
		
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
				detect(Main.vehicle);
			
		}
		
	}
	
}
