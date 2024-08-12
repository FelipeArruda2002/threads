package competition;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class CollectionForCompetition {

	private static List<String> lista = new CopyOnWriteArrayList<String>();
	private static Map<Integer, String> mapa = new ConcurrentHashMap<Integer, String>();
	private static Queue<String> fila = new LinkedBlockingQueue<String>();

	public static void main(String[] args) throws InterruptedException {
		MyRunnableList runnableList = new MyRunnableList();
		
		Thread t0 = new Thread(runnableList);
		Thread t1 = new Thread(runnableList);
		Thread t2 = new Thread(runnableList);
		
		t0.start();
		t1.start();
		t2.start();
		
		Thread.sleep(1000);
		System.out.println(lista);
		
		MyRunnableMap myRunnableMap = new MyRunnableMap();
		Thread t01 = new Thread(myRunnableMap);
		Thread t11 = new Thread(myRunnableMap);
		Thread t22 = new Thread(myRunnableMap);
		
		t01.start();
		t11.start();
		t22.start();
		
		Thread.sleep(1000);
		System.out.println(mapa);
		
		MyRunnableQueue myRunnableQueue = new MyRunnableQueue();
		Thread t001 = new Thread(myRunnableQueue);
		Thread t111 = new Thread(myRunnableQueue);
		Thread t222 = new Thread(myRunnableQueue);

		t001.start();
		t111.start();
		t222.start();
		
		Thread.sleep(1000);
		System.out.println(fila);
	}

	public static class MyRunnableMap implements Runnable {
		
		@Override
		public void run() {
			mapa.put(new Random().nextInt(), "Map");
			String name = Thread.currentThread().getName();
			System.out.println(String.format("%s, adicionou no map", name));
		}
	}

	public static class MyRunnableList implements Runnable {
		
		@Override
		public void run() {
			lista.add("Teste");
			String name = Thread.currentThread().getName();
			System.out.println(String.format("%s, adicionou na lista", name));
		}
	}

	public static class MyRunnableQueue implements Runnable {
		
		@Override
		public void run() {
			fila.add("Fila");
			String name = Thread.currentThread().getName();
			System.out.println(String.format("%s, adicionou na pilha", name));
		}
	}

}
