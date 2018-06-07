package greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/two-arrays/problem
 * @author sam
 *
 */
public class PermutingTwoArrays {
	// Complete the twoArrays function below.
    static String twoArrays(int k, int[] a, int[] b) {
    	Arrays.parallelSort(a);
    	Arrays.parallelSort(b);
    	
    	for(int i=0;i<a.length;i++){
    		if(a[i] + b[b.length-i-1] < k) return "NO";
    	}
    	return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = Integer.parseInt(scanner.nextLine());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

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

            System.out.println(twoArrays(k, A, B));
        }

        scanner.close();
    }
}
