package tasks.print;

public class PrintHelloTask implements Runnable {
	
	private String name;
	
	public PrintHelloTask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			System.out.println(String.format("%s foi interrompida!", this.name));
			e.printStackTrace();
		}
		System.out.println(String.format("Olá, %s!", this.name));
	}

}
