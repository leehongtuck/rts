package sequential;

public class AuthoritiesNotifier {
	public void run(Vehicle v) {
		System.out.println("Contacting highway authorities!");
		try {
			Thread.sleep(1000);	
		} catch(Exception e) {}
		System.out.println("Call received, dispatching tow truck to handle the problem!");
		try {
			Thread.sleep(2000);
		} catch(Exception e) {}
		System.out.println("Tow truck arrived, preparing to tow the vehicle away!");
		v.towed = true;
		System.out.println("Vehicle " + v.id + "is towed away!");
		
	}
}


