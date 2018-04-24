package sort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/big-sorting/problem
 * 
 * @author sam
 *
 */
public class BigSort {

	/*
	 * Complete the bigSorting function below.
	 */
	static String[] bigSorting(String[] unsorted) {
		return null;
	}
	
	class MyComparator<String> implements Comparable<String>{

		@Override
		public int compareTo(String o) {
			return 0;
		}
		
	}

	public static void main(String[] args) throws IOException {
		Scanner scan;
		BufferedWriter a;
		FileWriter b;
		String[] unsorted = { "31", "313", "1", "12", "231" };
		String[] sorted = bigSorting(unsorted);

		for (String s : sorted) {
			System.out.println(s);
		}

	}
}
