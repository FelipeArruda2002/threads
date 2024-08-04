package tasks;

public class Main {

	public static void main(String[] args) {
		
		Thread task1 = new Thread(new PrintHelloTask("Task 1"));
		Thread task2 = new Thread(new PrintHelloTask("Task 2"));
		Thread task3 = new Thread(new PrintHelloTask("Task 3"));
		Thread task4 = new Thread(new PrintHelloTask("Task 4"));
		Thread task5 = new Thread(new PrintHelloTask("Task 5"));
		
		// Executando as tarefas
		task1.start();
		task2.start();
		task3.start();
		task4.start();
		task5.start();

	}

}
