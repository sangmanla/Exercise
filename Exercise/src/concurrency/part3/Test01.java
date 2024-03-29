package concurrency.part3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Test01 {
	public static void main(String[] args) {
		AtomicInteger atomicInt = new AtomicInteger(0);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0, 1000)
		    .forEach(i -> {
		    	executor.submit(atomicInt::incrementAndGet);
		    });

		stop(executor);

		System.out.println("atomicInt.get() : " +  atomicInt.get());    // => 1000
	}
	
	private static void stop(ExecutorService executor) {
		executor.shutdown();
		try {
			executor.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void sleep(int sec){
		try {
			TimeUnit.SECONDS.sleep(sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
