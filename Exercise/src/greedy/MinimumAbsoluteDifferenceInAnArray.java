package greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 * @author sam
 *
 */
public class MinimumAbsoluteDifferenceInAnArray {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int n, int[] arr) {
    	Arrays.sort(arr);
    	int min = Integer.MAX_VALUE, temp = 0;
    	
    	for(int i=0;i<arr.length-1;i++){
    		min = Math.min(min, Math.abs(arr[i] - arr[i+1]));
    	}
    	return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(scanner.nextLine());

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(n, arr);

        System.out.println(result);

        scanner.close();
    }
}
