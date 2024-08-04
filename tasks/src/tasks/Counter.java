package tasks;

public class Counter {

	public static void main(String[] args) {
		// Definindo uma tarefa
		CounterTask counterTask = new CounterTask();
		
		Thread counter1 = new Thread(counterTask);
		Thread counter2 = new Thread(counterTask);
		Thread counter3 = new Thread(counterTask);
		Thread counter4 = new Thread(counterTask);
		
		counter1.start();
		counter2.start();
		counter3.start();
		counter4.start();
	}

}
