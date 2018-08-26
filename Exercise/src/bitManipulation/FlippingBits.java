package bitManipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/flipping-bits/problem
 * @author sam
 *
 */
public class FlippingBits {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		long max = 4294967295l;
		for(int i=0;i<num;i++){
			System.out.println(max - Long.parseLong(scan.nextLine()));
		}
		scan.close();
	}
}