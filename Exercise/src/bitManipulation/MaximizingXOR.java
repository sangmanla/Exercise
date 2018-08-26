package bitManipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maximizing-xor/problem
 * @author sam
 */
public class MaximizingXOR {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int start = Integer.parseInt(scan.nextLine()), end = Integer.parseInt(scan.nextLine());
		int[] bits = new int[end-start + 1];
		for(int i=0;i<bits.length;i++){
			bits[i] = start + i;
		}
		
		int maxBit = Integer.MIN_VALUE;
		for(int i=0;i<bits.length;i++){
			for(int j=0;j<bits.length;j++){
				maxBit = Integer.max(maxBit, bits[i] ^ bits[j]);
			}
		}
		
		System.out.println(maxBit);
		
		scan.close();
	}
}