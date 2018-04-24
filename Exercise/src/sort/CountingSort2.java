package sort;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/countingsort2/problem
 * @author sam
 *
 */
public class CountingSort2 {
	static int[] countingSort(int[] arr) {
		int[] cnts = new int[100];
        for(int i : arr){
            cnts[i]++;
        }
        
        int idx = 0;
        int[] result = new int[arr.length];
        for(int i=0;i<cnts.length;i++){
        	for(int j=0;j<cnts[i];j++){
        		result[idx++] = i;
        	}
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = countingSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
