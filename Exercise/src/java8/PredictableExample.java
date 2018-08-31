package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredictableExample {
    public static void main(String[] args) {
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
	
	// Call method with Predicate, so that inform method how to work
	sumAll(numbers, n -> true);
	sumAll(numbers, n -> n % 2 == 0);
	sumAll(numbers, n -> n > 3);
    }

    public static void sumAll(List<Integer> numbers, Predicate<Integer> p) {
	int total = 0;
	for (int number : numbers) {
	    if (p.test(number)) {
		total += number;
	    }
	}
	
	System.out.println(total);
    }
}