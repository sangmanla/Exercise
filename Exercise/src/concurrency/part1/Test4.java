package concurrency.part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test4 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(()->{
			String threadName = Thread.currentThread().getName();
			try {
				TimeUnit.SECONDS.sleep(6);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello " + threadName);
		});
		try{
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		}catch(InterruptedException e){
			System.out.println("tasks interrupted");
		}finally{
			if(!executor.isTerminated()){
				System.out.println("cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}
	}
}
