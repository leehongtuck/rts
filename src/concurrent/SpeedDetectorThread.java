package concurrent;

import sequential.SpeedDetector;
import sequential.Vehicle;

public class SpeedDetectorThread extends SpeedDetector implements Runnable {
	Vehicle v;
	
	public SpeedDetectorThread(Vehicle v) {
		this.v = v;
	}
	
	@Override
	public void run() {
		super.detect(v);
	}
	
}
