package greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/greedy-florist/problem
 * 
 * @author sam
 */
public class GreedyFlorist {

	// Complete the getMinimumCost function below.
	static int getMinimumCost(int n, int k, int[] c) {
		int totalCost = 0;
		Arrays.parallelSort(c);
		
		for(int i=0;i<c.length;i++){
			int m = (int)(Math.floor(i/k) + 1);
			totalCost += c[c.length - i - 1] * m;
		}
		
		return totalCost;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nk = scanner.nextLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		System.out.println(getMinimumCost(n, k, c));
		scanner.close();
	}
}
