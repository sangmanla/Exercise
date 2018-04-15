import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

public class Test extends RecursiveAction {
	public static void main(String[] args) {
		Test action = new Test("asjdflkasfjaslkfjasklfjasklghaslfkjasf");
		action.compute();
	}

	private String workload = "";
	private static final int THRESHOLD = 4;

	public Test(String workload) {
		this.workload = workload;
	}
	// 호출
	@Override
	protected void compute() {
		if (workload.length() > THRESHOLD) {
			ForkJoinTask.invokeAll(createSubtasks());
			AtomicInteger in =new AtomicInteger(10);
//			in.compareAndSet(expect, update);
		} else {
			processing(workload);
		}
	}

	// 분해
	private List<Test> createSubtasks() {
		List<Test> subtasks = new ArrayList<>();
		String partOne = workload.substring(0, workload.length() / 2);
		String partTwo = workload.substring(workload.length() / 2, workload.length());
		subtasks.add(new Test(partOne));
		subtasks.add(new Test(partTwo));
		return subtasks;
	}

	// 처리
	private void processing(String work) {
		String result = work.toUpperCase();
		System.out.println("This result - (" + result + ") - was processed by " + Thread.currentThread().getName());
	}
}