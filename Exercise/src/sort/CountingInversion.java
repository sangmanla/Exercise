package sort;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-merge-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 * 
 * @author Sangman Na
 *
 */
public class CountingInversion {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] arr = new int[n];

			String[] arrItems = scanner.nextLine().split(" ");

			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}

			long result = countInversions(arr);

			System.out.println(result);
		}

		scanner.close();
	}

	private static long result = 0;

	private static long countInversions(int[] arr) {
		result = 0;
		mergeSort(0, arr.length - 1, arr);
		return result;
	}

	private static void mergeSort(int start, int end, int[] arr) {
		if (end <= start) {
			return;
		} else {
			int mid = start + (end - start) / 2;
			mergeSort(start, mid, arr);
			mergeSort(mid + 1, end, arr);
			merge(arr, start, mid, end);

		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int size1 = mid - start + 1;
		int size2 = end - mid;
		int[] arr1 = new int[size1];
		int[] arr2 = new int[size2];

		for (int i = 0; i < size1; i++) {
			arr1[i] = arr[i + start];
		}

		for (int i = 0; i < size2; i++) {
			arr2[i] = arr[mid + i + 1];
		}

		int idx1 = 0, idx2 = 0, idx0 = start;

		while (idx1 < size1 && idx2 < size2) {
			if (arr1[idx1] > arr2[idx2]) {
				result += size1 - idx1;
				arr[idx0] = arr2[idx2];
				idx2++;
			} else if (arr1[idx1] <= arr2[idx2]) {
				arr[idx0] = arr1[idx1];
				idx1++;
			}
			idx0++;
		}

		while (idx1 <= arr1.length - 1) {
			arr[idx0] = arr1[idx1];
			idx0++;
			idx1++;
		}

		while (idx2 <= arr2.length - 1) {
			arr[idx0] = arr2[idx2];
			idx0++;
			idx2++;
		}
	}
}
