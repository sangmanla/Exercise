package greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/beautiful-pairs/problem
 * 
 * @author sam
 *
 */
public class BeautifulPair {

	// Complete the beautifulPairs function below.
	static int beautifulPairs(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);

		boolean end = false;
		int aIdx = 0, bIdx = 0;
		int beautifulPair = 0;

		while (!end) {
			if (A[aIdx] == B[bIdx]) {
				beautifulPair++;
				aIdx++;
				bIdx++;
			} else if (A[aIdx] > B[bIdx]) {
				bIdx++;
			} else {
				aIdx++;
			}

			if (aIdx == A.length || bIdx == B.length) {
				end = true;
			}
		}

		if(beautifulPair < A.length) beautifulPair++;
		else if(beautifulPair == A.length) beautifulPair--;
		
		return beautifulPair;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(scanner.nextLine());

		int[] A = new int[n];

		String[] AItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int AItem = Integer.parseInt(AItems[i]);
			A[i] = AItem;
		}

		int[] B = new int[n];

		String[] BItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int BItem = Integer.parseInt(BItems[i]);
			B[i] = BItem;
		}

		System.out.println(beautifulPairs(A, B));

		scanner.close();
	}
}
