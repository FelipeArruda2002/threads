package terminate.threads;


public class Runner implements Runnable {
	
	private Race race;
	private String runner;
	
	public Runner(Race race, String runner) {
		super();
		this.race = race;
		this.runner = runner;
	}

	@Override
	public void run() {
		System.out.println(runner + " running...");

		synchronized (race) {
			if (!race.isFinished()) {
				race.setFinished(true);
				race.incrementPosition();
				System.out.println(runner + " was in 1st position");
			} else {
				race.incrementPosition();
				System.out.println(runner + " was in " + race.getPosition() + "nd position");
			}
		}
	}

}
