import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
	static Future<String> future = null;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("in Main Thread.currentThread().getName() : " + Thread.currentThread().getName());
		
		Callable<String> call = () -> {
			System.out.println("before");
			System.out.println("Thread.currentThread().getName() : " + Thread.currentThread().getName());
			Thread.sleep(10000);
			System.out.println("after");
			return "result from callable";
		};

		ExecutorService service = Executors.newSingleThreadExecutor();
		System.out.println("exeute now");
		future = service.submit(call);
		future = service.submit(call);
		System.out.println("after execution");

		service.shutdown();
		System.out.println("1``````````1");
	}
}
