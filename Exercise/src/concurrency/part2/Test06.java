package concurrency.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class Test06 {
	static int count = 0;
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		StampedLock lock = new StampedLock();
		
		executor.submit(() ->{
			try{
				lock.writeLock();
				sleep(1);
			}finally{
				lock.tryUnlockWrite();
			}
		});
		
		executor.submit(() -> {
		    long stamp = lock.readLock();
		    try {
		        if (count == 0) {
		            stamp = lock.tryConvertToWriteLock(stamp);
		            if (stamp == 0L) {
		                System.out.println("Could not convert to write lock");
		                stamp = lock.writeLock();
		            }
		            count = 23;
		        }
		        System.out.println(count);
		    } finally {
		        lock.unlock(stamp);
		    }
		});
		
		

		stop(executor);
	}
	
	private static void stop(ExecutorService executor) {
		executor.shutdown();
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
