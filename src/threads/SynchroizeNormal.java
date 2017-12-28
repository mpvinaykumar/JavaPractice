package threads;

import java.util.ArrayList;
import java.util.Random;

/*https://www.javacodegeeks.com/2011/10/concurrency-optimization-reduce-lock.html
*/	
public class SynchroizeNormal {
	private final ArrayList fruits = new ArrayList();
	private final ArrayList vegetables = new ArrayList();
	Random random = new Random();

	public synchronized void addFruit(int index, String fruit) {
		fruits.add(index, fruit);
	}

	public synchronized void removeFruit(int index) {
		fruits.remove(index);
	}

	public synchronized void addVegetable(int index, String vegetable) {
		vegetables.add(index, vegetable);
	}

	public synchronized void removeVegetable(int index) {
		vegetables.remove(index);
	}

	private void doLock() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					addFruit(i, i+"t1");
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					addVegetable(i, i+"t2");
				}
			}
		});

		t1.start();
		t2.start();

		// main-thread waits for completion of t1 and t2 threads
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (Object object : fruits) {
			System.out.println(object.toString());
		}
		for (Object object : vegetables) {
			System.out.println(object.toString());
		}

	}

	public static void main(String[] args) {
		new SynchroizeNormal().doLock();
	}
}