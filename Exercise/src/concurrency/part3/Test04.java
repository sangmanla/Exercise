package concurrency.part3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Test04 {
	public static void main(String[] args) {
		LongAdder adder = new LongAdder();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0, 1000)
			.forEach(i -> executor.submit(adder::increment));
		
		stop(executor);
		
		System.out.println(adder.sumThenReset());
		System.out.println(adder.sumThenReset());
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
