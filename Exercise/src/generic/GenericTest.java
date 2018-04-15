package generic;

import java.util.Scanner;

public class GenericTest {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Integer[] intArray = new Integer[n];
		for (int i = 0; i < n; i++) {
			intArray[i] = scanner.nextInt();
		}

		n = scanner.nextInt();
		String[] stringArray = new String[n];
		for (int i = 0; i < n; i++) {
			stringArray[i] = scanner.next();
		}
		
		
		// 결과 1
		Printer<Integer> intPrinter = new Printer<Integer>();
		Printer<String> stringPrinter = new Printer<String>();
		intPrinter.printArray(intArray);
		stringPrinter.printArray(stringArray);
		if (Printer.class.getDeclaredMethods().length > 1) {
			System.out.println("The Printer class should only have 1 method named printArray.");
		}
		
		// 결과 2  - 결과 1과 동일한 내용이 출력됨
		Printer2 mine = new Printer2();
		mine.printArray(intArray);
		mine.printArray(stringArray);

		scanner.close();
	}
}

class Printer<T> {
	public void printArray(T[] items) {
		for (T item : items)
			System.out.println(item);
	}
}


class Printer2 {
	public <T> void printArray(T[] items){
		for (T item : items)
			System.out.println(item);
	}
}