package concurrency.part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test3 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(()->{
			String threadName = Thread.currentThread().getName();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello " + threadName);
		});
		System.out.println("before shutdown");
		executor.shutdown();
		System.out.println("after shutdown");
	}
}
