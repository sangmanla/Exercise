package dp;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
 * 
 * @author Sangman Na
 *
 */
public class MaxArraySum {
//	public static void main(String[] args) {
//		// int[] sample = {3, 7, 4, 6, 5}; // 13
////		int[] sample = {2, 1, 5, 8, 4};
//		int[] sample = {3, 5, -7, 8, 10};
//		
//		System.out.println(maxSubsetSum(sample));
//	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		System.out.println(maxSubsetSum(arr));
		System.out.println(maxSubsetSum2(arr));

		scanner.close();
	}

	// Complete the maxSubsetSum function below.
	static int maxSubsetSum(int[] arr) {
		int[] max = new int[2];
		max[0] = Math.max(0, arr[0]);
		max[1] = Math.max(max[0], arr[1]);
		
		for (int i = 2; i < arr.length; i++) {
			int tmp = Math.max(max[0] + arr[i], max[1]);
			max[0] = max[1];
			max[1] = tmp;
		}
		return Math.max(max[0], max[1]);
	}

	public static int maxSubsetSum2(int[] arr) {
		if (arr.length == 0)
			return 0;
		if (arr.length == 1)
			return arr[0];
		
		arr[0] = Math.max(0, arr[0]);
		arr[1] = Math.max(arr[0], arr[1]);
		
		for (int i = 2; i < arr.length; i++)
			arr[i] = Math.max(arr[i - 1], arr[i] + arr[i - 2]);
		
		System.out.println(getStr(arr));
		return arr[arr.length - 1];
	}

	private static String getStr(int[] copyOfRange) {
		StringBuffer str = new StringBuffer("");
		Arrays.stream(copyOfRange).forEach(x -> str.append(x + ","));
		return str.toString();
	}
}
