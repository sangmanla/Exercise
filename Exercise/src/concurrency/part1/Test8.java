package concurrency.part1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Test8 {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executor = Executors.newWorkStealingPool();
		List<Callable<String>> calls = Arrays.asList(
				callable("task1", 3),
				callable("task2", 1),
				callable("task3", 2));
		String result = executor.invokeAny(calls);
		System.out.println("result : " + result);
		
	}
	
	static Callable<String> callable(String result, long sleepSeconds){
		return () -> {
			System.out.println("in the callable before : " + result);
			TimeUnit.SECONDS.sleep(sleepSeconds);
			System.out.println("in the callable after : " + result);
			return result;
		};
	}
}
