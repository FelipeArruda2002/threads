package thread_runnable;

public class Main {

	public static void main(String[] args) {
		// Thread atual
		Thread current = Thread.currentThread();
		System.out.println(current.getName());
		
		MyRunnable runnable = new MyRunnable();
		
		Thread t1 = new Thread(runnable);
		t1.run(); // Apenas executa na mesma thread(Main)
		
		// Runnable como lambda
		Thread t2 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
		t2.start(); // Executa em uma nova thread
		// t2.start(); Lança exceção se startar mais de uma vez
		
		Thread t3 = new Thread(runnable);
		
		// Executando várias threads
		t1.start();
		t3.start();
	}

}
