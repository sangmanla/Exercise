package concurrency.part1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

public class Test7 {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executor = Executors.newWorkStealingPool();
		List<Callable<String>> calls = Arrays.asList(
				()-> "task1",
				()-> "task2",
				()-> "task3"
				);
		
		executor.invokeAll(calls)
			.stream()
			.map(future -> {
				try{
					return future.get();
				}catch(Exception e){
					throw new IllegalStateException(e);
				}
			}).forEach(System.out::println);;
		
		executor.shutdown();
	}
}
