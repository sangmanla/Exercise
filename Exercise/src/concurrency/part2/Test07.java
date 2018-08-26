package concurrency.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Test07 {
	static int count = 0;
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		Semaphore sp = new Semaphore(5);
		
		Runnable longRunningTask = () -> {
			boolean permit = false;
			try{
				sp.acquire();
				permit = sp.tryAcquire(1, TimeUnit.SECONDS);
				if(permit){
					System.out.println("Semaphore acquired");
//					sleep(1);
				} else {
					System.out.println("Could not acquire semaphore");
				}
				
			}catch(InterruptedException e){
				throw new IllegalStateException(e);
			}finally{
				if(permit){
					sp.release();
				}
			}
		};
		
		IntStream.range(1, 10).forEach(i -> {
			System.out.println(i);
			executor.submit(longRunningTask);
		});

		stop(executor);
	}
	
	private static void stop(ExecutorService executor) {
		try {
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
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
