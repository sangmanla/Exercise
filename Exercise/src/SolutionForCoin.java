import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionForCoin {

//    static long getWays(int amount, int[] coins){
//        long[] combinations = new long[amount + 1];
//		
//		combinations[0] = 1;
//		
//		for(int coin : coins){
//			System.out.println("\ncoin : " + coin);
//			for(int i = 1; i < combinations.length; i++){
//				System.out.println("i : " + i);
//				if(i >= coin){
//					combinations[i] += combinations[i - coin];
//					print(combinations);
//				}
//			}
//	   	}
//	    return combinations[amount];
//	}
    
    public static void print(long[] a){
    	for(long b : a) System.out.print(b + ",");
    	System.out.println();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
	private static long getWays(int n, int[] c) {
		long[] combination = new long[n+1];
		combination[0] = 1;
		
		for(int coin : c){
			for(int i=1;i<combination.length;i++){
				if(i>=coin){
					combination[i] += combination[i-coin];
				}
			}
		}
		return combination[n];
	}
}
