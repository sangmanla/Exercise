package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MissingNumber {
	static int[] missingNumbers(int[] arr, int[] brr) {
		ArrayList<Integer> list = new ArrayList<>();
		Arrays.sort(brr);
		Arrays.sort(arr);

		int arrIdx = 0;
		for(int i=0;i<brr.length;i++){
			if(arrIdx < arr.length && brr[i] == arr[arrIdx]) {
				arrIdx++;
				continue;
			}else{
				if(!list.contains(brr[i])) list.add(brr[i]);
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
        int m = in.nextInt();
        int[] brr = new int[m];
        for(int brr_i = 0; brr_i < m; brr_i++){
            brr[brr_i] = in.nextInt();
        }
        int[] result = missingNumbers(arr, brr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
