package threads;

public class SynchronizeObjLevel {

	int count = 0;

	private synchronized void increment() {
		count++;
	}

	private void doLock() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					increment();
				}
			}
		});

		t1.start();
		t2.start();

		//main-thread waits for completion of t1 and t2 threads
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(count);

	}

	public static void main(String[] args) {
		new SynchronizeObjLevel().doLock();
	}
}
