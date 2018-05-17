import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the angryChildren function below.
    static int angryChildren(int k, int[] arr) {
    	Arrays.sort(arr);
    	int resultMin = Integer.MAX_VALUE;
    	for(int i=0;i<arr.length-k+1;i++){
    		resultMin = Math.min(resultMin, arr[i+k-1] - arr[i]);
    	}
    	return resultMin;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        System.out.println(angryChildren(k, arr));
        scanner.close();
    }
}