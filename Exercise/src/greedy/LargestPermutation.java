package greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/largest-permutation/problem
 * 
 * @author sam
 *
 */
public class LargestPermutation {

	// Complete the largestPermutation function below.
	static int[] largestPermutation(int k, int[] arr) {
		HashMap<Integer, Integer> posMap = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++){
			posMap.put(arr[i], i);
		}
		
		for(int i=0;i<arr.length;i++){
			int shouldNum = arr.length - i; 
			if(shouldNum != arr[i]){
				posMap.put(arr[i], posMap.get(shouldNum));
				
				int temp = arr[i];
				arr[i] = arr[posMap.get(shouldNum)];
				arr[posMap.get(shouldNum)] = temp;
				
				posMap.put(shouldNum, i);
				
				k--;
			}
			if(k==0) break;
		}
		return arr;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nk = scanner.nextLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		int[] arr = new int[n];
		String[] arrItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		Arrays.stream(largestPermutation(k, arr)).forEach(v -> System.out.print(v + " "));
		scanner.close();
	}
}
