package threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompleteableFutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompleteableFutureExample example = new CompleteableFutureExample();
		for (int j = 0; j < 10; j++) {
			int k = j;
			// System.out.println("return value:"+ completeFut(k));
			System.out.println("last linke:" + j);
		}

//		String response = "<Duration>00:02:17</Duration>"
//				+ "<MediaFile delivery=\"progressive\" width=\"854\" height=\"480\" type=\"video/webm\" bitrate=\"594\" scalable=\"false\" maintainAspectRatio=\"false\">\r\n" + 
//				"<![CDATA[\r\n" + 
//				"https://gcdn.2mdn.net/videoplayback/id/9caf68e1f96a3f92/itag/44/source/doubleclick_dmm/ctier/L/acao/yes/ip/0.0.0.0/ipbits/0/expire/3708617106/sparams/id,itag,source,ctier,acao,ip,ipbits,expire/signature/469BBDEFE46562DB732BA0D6DE9663DFE9F51183.21D432FECED382ECE283D29F64C5E63921DCE8C8/key/ck2/file/file.webm\r\n" + 
//				"]]>\r\n" + 
//				"</MediaFile>\r\n" + 
//				"<MediaFile delivery=\"progressive\" width=\"1280\" height=\"720\" type=\"video/webm\" bitrate=\"1438\" scalable=\"false\" maintainAspectRatio=\"false\">\r\n" + 
//				"<![CDATA[\r\n" + 
//				"https://gcdn.2mdn.net/videoplayback/id/9caf68e1f96a3f92/itag/45/source/doubleclick_dmm/ctier/L/acao/yes/ip/0.0.0.0/ipbits/0/expire/3708617124/sparams/id,itag,source,ctier,acao,ip,ipbits,expire/signature/19DA14092D2C1DDD8E4ADEA4DE6C57E02C266567.85B4A76B12210190451903124EEA014FC9FF5034/key/ck2/file/file.webm\r\n" + 
//				"]]>\r\n" + 
//				"</MediaFile>";
//		int widthBegin = response.indexOf("width=\"");
//		String width = response.substring(widthBegin);
//		System.out.println(width.substring(0, width.indexOf("\" ") ));
//		
//		final Pattern pattern = Pattern.compile("<Duration>(.+?)</Duration>", Pattern.DOTALL);
//		final Matcher matcher = pattern.matcher(response);
//		matcher.find();
//		System.out.println( matcher.group(1));

		if (example.timeOut()) {
			System.out.println("timeout -true");
		} else {
			System.out.println("timeout -false");
		}
	}

	private boolean timeOut() {
		final ExecutorService executor = Executors.newSingleThreadExecutor();
		final Future future = executor.submit(() -> {
			Boolean isAvlbl = true;
			for (int i = 0; i < 50; i++) {
				if(isAvlbl) {
					System.out.println("B4 sleep...."+i);
					//Thread.sleep(2000);
					System.out.println("A4 sleep...."+i);
				}
				
			}
		});
		executor.shutdown(); // This does not cancel the already-scheduled task.

		try {
			future.get(1, TimeUnit.SECONDS);
		} catch (InterruptedException ie) {
			System.out.println("InterruptedException");
		} catch (ExecutionException ee) {
			System.out.println("ExecutionException");
		} catch (TimeoutException te) {
			System.out.println("TimeoutException");
			future.cancel(true);
			return true;
		}
		if (!executor.isTerminated())
			executor.shutdownNow();
		return false;
	}

	private static Integer completeFut(int k) throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> k * 5).thenApply(i -> i).thenApply(i -> {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return i;
		});
		return cf.join();
	}

}
