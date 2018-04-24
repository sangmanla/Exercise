package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/closest-numbers/problem
 * @author sam
 *
 */
public class ClosestNumber {
	static int[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        int[] diffArr = new int[arr.length-1];
        
        int minDiff = 100000000;
        for(int i=0;i<arr.length-1;i++){
        	int cur = arr[i], next = arr[i+1];
        	diffArr[i] = next - cur;
        	
        	minDiff = Integer.min(minDiff, diffArr[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<diffArr.length;i++){
        	if(diffArr[i] == minDiff) {
        		list.add(arr[i]);
        		list.add(arr[i+1]);
        	}
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = closestNumbers(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
