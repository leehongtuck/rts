package realtime;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

public class SpeedDetector extends RealtimeThread{
	Vehicle prev, v;
	Interruptible detect, response;
	AsynchronouslyInterruptedException aie;
	boolean accident;
	
	
	public SpeedDetector(AsynchronouslyInterruptedException aie) {
		this.aie = aie;
		detect = new SpeedDetection();
		response = new AccidentResponse();
	}
	
	
	@Override
	public void run() {
		while(true) {
			if(!accident) {
				System.out.println("accidnet not happening");
				aie.doInterruptible(detect);
			}
			else {
				aie.doInterruptible(response);
			}
			try {
				waitForNextRelease();
			} catch (IllegalThreadStateException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	class SpeedDetection implements Interruptible {

		@Override
		public void interruptAction(AsynchronouslyInterruptedException exception) {
			// TODO Auto-generated method stub
			accident = true;
		}

		@Override
		public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {
			// TODO Auto-generated method stub
			if(prev != Main.vehicle) {
				v = Main.vehicle;
				if(v.speed == 0) {
					aie.fire();
				}
				System.out.println("Vehicle " + v.id + " is moving at a speed of " + v.speed + "km/h" );
				prev = v;
			}	
		}
		
	}

	class AccidentResponse implements Interruptible {

		@Override
		public void interruptAction(AsynchronouslyInterruptedException exception) {
			// TODO Auto-generated method stub
			accident = false;
			
		}

		@Override
		public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {
			// TODO Auto-generated method stub
			System.out.println("Vehicle " + v.id + " , a " + v.type + " has broken down!");
			new Thread(new AuthoritiesNotifier(v)).start();;
			new Thread(new GpsNotifier(v)).start();
			aie.fire();
		}
		
	}


	
}


