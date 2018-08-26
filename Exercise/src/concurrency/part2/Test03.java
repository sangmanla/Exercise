package concurrency.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Test03 {
	Lock lock = new ReentrantLock();
	int count = 0;
	void incrementSync() {
//		lock.lock();
		try{
			count++;
//			System.out.println(count);
		}finally{
//			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		new Test03().test();
	}
	
	public void test(){
		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0, 10000)
			.forEach(i -> executor.submit(this::incrementSync));
		
		System.out.println(count);
		executor.shutdown();
	}
}
