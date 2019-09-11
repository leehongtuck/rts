package concurrent;

import sequential.SpeedDetector;
import sequential.Vehicle;

public class SpeedDetectorThread extends SpeedDetector implements Runnable {
	Vehicle v;
	
	@Override
	public void run() {
		while(true) {
			super.detect(v);
		}
	}
	
}
