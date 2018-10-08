package concurrency.part1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Test5 {
    public static void main(String[] args) {
	Callable<Integer> task = () -> {
	    try {
		TimeUnit.SECONDS.sleep(1);
		return 123;
	    } catch (InterruptedException e) {
		throw new IllegalStateException("task interrupted", e);
	    }
	};

	ExecutorService executor = Executors.newFixedThreadPool(1);
	Future<Integer> future = executor.submit(task);
	System.out.println("future done? " + future.isDone());

	try {
	    System.out.println("future done? " + future.isDone());
	    System.out.println("result: " + future.get());
	} catch (InterruptedException | ExecutionException e) {
	    e.printStackTrace();
	}
	executor.shutdownNow();

	try {
	    System.out.println("result: " + future.get());
	} catch (InterruptedException | ExecutionException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
