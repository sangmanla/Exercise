package arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * 
 * @author sam
 *
 */
public class ArrayManipulation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();

		long[] arr = new long[n];

		int left, right;
		long add;

		for (int i = 0; i < n; i++)
			arr[i] = 0;

		for (int i = 0; i < m; i++) {
			left = scanner.nextInt();
			right = scanner.nextInt();
			add = scanner.nextInt();
			arr[left - 1] += add;
			if (right < n) {
				arr[right] -= add;
			}
		}

		long max = 0, sum = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum > max) {
				max = sum;
			}
		}
		
		System.out.println(max);

		scanner.close();
	}
}
