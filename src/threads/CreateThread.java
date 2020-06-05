package threads;

class GThread extends Thread {
	public void run() {
		System.out.println("GThread: run()");
	}

	// will invoke this override start()
	/*public void start() {
		System.out.println("GThread: start()");
	}*/
}

class GRunnable implements Runnable {
	public void run() {
		System.out.println("GRunnable: run()");
	}

	public void start() {
		System.out.println("GRunnable: start()");
	}
}

public class CreateThread {
	public static void main(String args[]) {
		GThread g_thread = new GThread();
		GRunnable g_runnable = new GRunnable();

		g_thread.start();
		Thread thread = new Thread(g_runnable);
		thread.start();
	}
}