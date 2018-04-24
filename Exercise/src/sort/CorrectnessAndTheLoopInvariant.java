package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/correctness-invariant/problem
 * @author sam
 *
 */
public class CorrectnessAndTheLoopInvariant {
	static int[] gArr;
	
	static void insertionSort(int[] arr) {
		gArr = arr;
        for(int i=1;i<gArr.length;i++){
        	for(int j=i-1;j>=0;j--){
        		if(gArr[j] > gArr[j+1]){
        			int t = gArr[j+1];
        			gArr[j+1] = gArr[j];
        			gArr[j] = t;
        		}
        	}
        	
        }
        printArray();
    }
	
	static void printArray(){
        Arrays.stream(gArr).forEach(v -> System.out.print(v + " "));
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
        in.close();
    }
}
