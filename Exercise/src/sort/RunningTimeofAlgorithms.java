package sort;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/runningtime/problem
 * @author sam
 *
 */
public class RunningTimeofAlgorithms {
	
	static int runningTime(int[] arr) {
		int cnt = 0;
        for(int i=1;i<arr.length;i++){
        	for(int j=i-1;j>=0;j--){
        		if(arr[j] > arr[j+1]){
        			int t = arr[j+1];
        			arr[j+1] = arr[j];
        			arr[j] = t;
        			cnt++;
        		}
        	}
        }
        return cnt;
    }
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = runningTime(arr);
        System.out.println(result);
        in.close();
    }
}
