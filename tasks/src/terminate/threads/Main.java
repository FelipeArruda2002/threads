package terminate.threads;

public class Main {

	public static void main(String[] args) {
		Race race = new Race();
		Thread runner1 = new Thread(new Runner(race, "Felipe"));
		Thread runner2 = new Thread(new Runner(race, "Daniela"));
		Thread runner3 = new Thread(new Runner(race, "Dayane"));
		Thread runner4 = new Thread(new Runner(race, "Aline"));
		
		System.out.println("Starting...");
		
		runner1.start();
		runner2.start();
		runner3.start();
		runner4.start();
	}
	
}
