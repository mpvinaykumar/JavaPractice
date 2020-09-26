package threads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MapTypes {

	Map<Integer, Integer> hashMap = new HashMap<>();
	Map<Integer, Integer> syncMap = Collections.synchronizedMap(hashMap);
	//Map<String, Integer> syncMap = new ConcurrentHashMap<String, Integer>();

//	Runnable r = () -> {
//		String threadName = Thread.currentThread().getName();
//		System.out.println("Hello " + threadName);
//		syncMap.put(threadName, 1);
//		try {
//			System.out.println("MapHelper1 sleeping");
//			Thread.sleep(100);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	};
//
//	Thread t1 = new Thread(r);
//	Thread t2 = new Thread(r);
//	Thread t3 = new Thread(r);

	public static void main(String[] args) {
		MapTypes mapTypes = new MapTypes();
		ExecutorService executor = Executors.newFixedThreadPool(5);

		int count[] = {1};
		Runnable r = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
			mapTypes.syncMap.put(count[0]++, mapTypes.syncMap.size());
			try {
				System.out.println("MapHelper1 sleeping");
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println(e);
			}
		};
		for (int i = 0; i < 10; i++) {
			executor.execute(r);
		}
		executor.shutdown();

//		while (!executor.isTerminated()) {
//		}
//		System.out.println("Finished all threads");
		
		for (Map.Entry<Integer, Integer> e : mapTypes.syncMap.entrySet()) {
			System.out.println(e.getKey() + "=" + e.getValue());
		}

	}
}
