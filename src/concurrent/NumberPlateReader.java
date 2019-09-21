package concurrent;

public class NumberPlateReader implements Runnable{
	Vehicle prev;
	
	public void read(Vehicle v) {
		System.out.println("Vehicle " + v.id + " number plate is " + v.numPlate);
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
				read(Main.vehicle);
		}
		
	}
}
