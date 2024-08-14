package competition;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicClass {

	private static AtomicInteger atomicInt = new AtomicInteger(0);
	private static AtomicBoolean atomicBool = new AtomicBoolean(false);
	private static AtomicReference<String> atomicRef = new AtomicReference<String>("Cr7");
	
	
	public static void main(String[] args) throws InterruptedException {
		Runnable taskInteger = () -> {
			String name = Thread.currentThread().getName();
			System.out.println("Thread " + name  + " " + atomicInt.incrementAndGet());
		};
		
		Runnable taskBoolean = () -> {
			String name = Thread.currentThread().getName();
			System.out.println("Thread " + name  + " " + atomicBool.compareAndExchange(false, true));
		};		
		
		Runnable taskReference = () -> {
			String name = Thread.currentThread().getName();
			System.out.println("Thread " + name  + " " + atomicRef.getAndSet("Teste"));
		};
		
		executeTask(taskInteger);
		executeTask(taskBoolean);
		executeTask(taskReference);
	}

	public static void executeTask(Runnable runnable) throws InterruptedException {
		Thread t0 = new Thread(runnable);
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		
		t0.start();
		t1.start();
		t2.start();
		Thread.sleep(500);
	}
	
}