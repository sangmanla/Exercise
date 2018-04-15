import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static int equal(int[] arr) {

	    Arrays.sort(arr);

	    int sum = Integer.MAX_VALUE;

	    for(int base = 0; base < 3; base++) {
	        int cSum = 0;
	        for(int i = 0; i < arr.length; i++) {
	            int delta = arr[i] - arr[0] + base;
	            cSum += (int)delta / 5 + delta % 5 / 2 + delta % 5 % 2 / 1;
	        }
	        sum = Math.min(cSum,sum);
	    }

	    return sum;
	}
	
	public class MsLunch {
	    private long c1 = 0;
	    private long c2 = 0;
	    private Object lock1 = new Object();
	    private Object lock2 = new Object();

	    public void inc1() {
	        synchronized(lock1) {
	            c1++;
	        }
	    }

	    public void inc2() {
	        synchronized(lock2) {
	            c2++;
	        }
	    }
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = equal(arr);
            System.out.println(result);
        }
        in.close();
    }
}
