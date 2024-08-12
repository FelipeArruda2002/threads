package competition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncCollection {

	private static List<String> lista = new ArrayList<>();
	
	public static void main(String[] args) throws InterruptedException {
		lista = Collections.synchronizedList(lista);
		
		MyRunnable runnable = new MyRunnable();
		
		Thread t0 = new Thread(runnable);
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		t0.start();
		t1.start();
		t2.start();
		
		Thread.sleep(1000);
		System.out.println(lista);
	}
	
	public static class MyRunnable implements Runnable {
		
		@Override
		public void run() {
			lista.add("Teste");
			String name = Thread.currentThread().getName();
			System.out.println(String.format("%s, adicionou na lista", name));
		}
	}

}
