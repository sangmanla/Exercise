package rxJava;

import io.reactivex.Observable;

/**
 * http://krksap.tistory.com/1189
 */
public class FirstExample {
	public static void main(String[] args) {
		FirstExample test = new FirstExample();
		test.emit();
	}

	private void emit() {
		Observable.just("hello", "rxjava2!!").subscribe(System.out::println); 
	}
}
