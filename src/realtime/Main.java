package realtime;

import javax.realtime.*;

public class Main {
	static volatile Vehicle vehicle;
	
	public static void main(String[] args) {
		AsynchronouslyInterruptedException aie = new AsynchronouslyInterruptedException();
		
		ReleaseParameters rel = new PeriodicParameters(new RelativeTime(1000, 0));
		ReleaseParameters vgRel = new PeriodicParameters(new RelativeTime(1200, 0));
		
		RealtimeThread npr = new NumberPlateReader();
		RealtimeThread sd = new SpeedDetector(aie);
		RealtimeThread vc = new VehicleClassifier();
		
		npr.setReleaseParameters(rel);
		sd.setReleaseParameters(rel);
		vc.setReleaseParameters(rel);
		
		RealtimeThread vg = new VehicleGenerator(aie);
		vg.setReleaseParameters(vgRel);
		
		npr.start();
		sd.start();
		vc.start();
		
		vg.start();
	}
}
