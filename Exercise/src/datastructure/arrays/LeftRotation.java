package datastructure.arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/array-left-rotation/problem
 * @author sam
 *
 */
public class LeftRotation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		int rot = scan.nextInt() % count;
		int[] vals = new int[count];
		
		for(int i=0;i<count;i++){
			vals[(i + (count - rot)) % count] = scan.nextInt();
		}
		
		for(int i=0;i<count;i++){
			System.out.print(vals[i] + " ");
		}
		
		scan.close();
	}
}
