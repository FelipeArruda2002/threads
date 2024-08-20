package competition;

import java.lang.Thread.State;

public class Volatile {

	//private static int number = 0;
	//private static boolean prepared = false;
	
	private static volatile int number = 0;
	private static volatile boolean prepared = false;

	public static void main(String[] args) {
		while (true) {
			Thread t0 = new Thread(new MyRunnable());
			t0.start();
			Thread t1 = new Thread(new MyRunnable());
			t1.start();
			Thread t2 = new Thread(new MyRunnable());
			t2.start();
			
			number = 57;
			prepared = true;
			
			while (t0.getState() != State.TERMINATED
					|| t1.getState() != State.TERMINATED
					|| t2.getState() != State.TERMINATED) {
			}
			
			number = 0;
			prepared = false;
		}
	}

	private static class MyRunnable implements Runnable {
		@Override
		public void run() {
			while (!prepared) {
				// Sugerindo que a CPU seja cedida para outras threads
				Thread.yield();
			}

			if (number != 57) {
				System.out.println(number);
			}
		}
	}

}
