package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insertionsort1/problem
 * @author sam
 *
 */
public class InsertionSortPart1 {
	static int[] gArr;
	
	static void insertionSort1(int n, int[] arr) {
		gArr = arr;
        int item = gArr[gArr.length-1];
        for(int i = gArr.length-2;i>=0;i--){
            if(gArr[i] > item){
            	gArr[i+1] = gArr[i];
                printArray();
                if(i==0){
                	gArr[0] = item;
                	printArray();
                }
            }else{
            	gArr[i+1] = item;
                printArray();
                break;
            }
        }
    }
    
    static void printArray(){
        Arrays.stream(gArr).forEach(v -> System.out.print(v + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort1(n, arr);
        in.close();
    }
}