package concurrent;

import sequential.Vehicle;
import sequential.VehicleClassifier;

public class VehicleClassifierThread extends VehicleClassifier implements Runnable{
	Vehicle v;
	
	public VehicleClassifierThread(Vehicle v) {
		this.v = v;
	}

	@Override
	public void run() {
		classify(v);	
	}
}
