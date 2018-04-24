package sort;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort1/problem
 * @author sam
 *
 */
public class QuickSort1Partition {
	static int[] quickSort(int[] arr) {
        int pivot = arr[0];
        ArrayList<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        
        for(int num : arr){
        	if(num < pivot) left.add(num);
        	else if(pivot == num) continue;
        	else right.add(num);
        }
        left.add(pivot);
        left.addAll(right);
        
        return left.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = quickSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");

        in.close();
    }
}