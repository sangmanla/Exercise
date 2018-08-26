package concurrency.part3;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Test06 {
	public static void main(String[] args) {
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		map.put("foo", "bar");
		map.put("han", "solo");
		map.put("r2", "d2");
		map.put("c3", "p0");
		map.putIfAbsent("c3", "p1");
		
		map.compute("r2", (key, value) -> value + value);
		
		map.merge("foo", "boo", (oldVal, newVal)-> newVal + " was " + oldVal); 
		map.forEach((key, value) -> System.out.printf("%s = %s\n", key, value));
		
		System.out.println(ForkJoinPool.getCommonPoolParallelism());
		
		System.out.println("------------------------");
		
		map.forEach(1, (key, value) ->
	    System.out.printf("key: %s; value: %s; thread: %s\n",
	        key, value, Thread.currentThread().getName()));
		
		String result = map.search(1, (key, value) -> {
			if(value.length() >2){
				return value;
			}
			return null;
		});
		System.out.println("Result : " + result);
		
		System.out.println("----------------------------------------");
		result = map.reduce(1,
			    (key, value) -> {
			        System.out.println("Transform: " + Thread.currentThread().getName());
			        return key + "=" + value;
			    },
			    (s1, s2) -> {
			        System.out.println("Reduce: " + Thread.currentThread().getName());
			        return s1 + ", " + s2;
			    });

			System.out.println("Result: " + result);
	}
	
	private static void stop(ExecutorService executor) {
		try {
			executor.shutdown();
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
