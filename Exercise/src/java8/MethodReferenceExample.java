package java8;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
	// Method Reference
	numbers.forEach(System.out::println);
	// instead of this
	//numbers.forEach(x -> System.out.println(x));
    }
}