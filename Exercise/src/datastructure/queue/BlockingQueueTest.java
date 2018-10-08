package datastructure.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueTest {
    public static void main(String[] args) {
	BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(10);
	ExecutorService es = Executors.newFixedThreadPool(5);
	es.submit(() -> produce(bq));
	es.submit(() -> consume(bq));
	es.submit(() -> consume(bq));
    }

    private static void consume(BlockingQueue<Integer> bq) {
	while (true) {
	    try {
		System.out.println(Thread.currentThread().getName() + " | " + bq.take());
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

    private static void produce(BlockingQueue<Integer> bq) {
	try {
	    int count = 1;
	    while (true) {
		Thread.sleep(300);
		bq.put(count++);
	    }
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
}
