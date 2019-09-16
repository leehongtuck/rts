package concurrent;

import sequential.NumberPlateReader;
import sequential.Vehicle;

public class NumberPlateReaderThread extends NumberPlateReader implements Runnable{
	Vehicle v;
	
	public NumberPlateReaderThread(Vehicle v) {
		this.v = v;
	}
	
	@Override
	public void run() {
		read(v);
	}

}
