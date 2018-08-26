package concurrency.part2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test02 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Map<String, String> map = new HashMap<>();
		ReadWriteLock lock = new ReentrantReadWriteLock();

		executor.submit(() -> {
		    lock.writeLock().lock();
		    try {
		    	System.out.println("before write");
		        TimeUnit.SECONDS.sleep(1);
		        map.put("foo", "bar");
		        System.out.println("after write");
		    }catch(InterruptedException e){
		    	e.printStackTrace();
		    } finally {
		        lock.writeLock().unlock();
		    }
		});
		
		Runnable readTask = () -> {
		    lock.readLock().lock();
		    try {
		    	System.out.println("before read");
		        System.out.println(map.get("foo"));
		        TimeUnit.SECONDS.sleep(1);
		        System.out.println("after read");
		    }catch(InterruptedException e){
		    	e.printStackTrace();
		    } finally {
		        lock.readLock().unlock();
		    }
		};

		executor.submit(readTask);
		executor.shutdown();
	}
}