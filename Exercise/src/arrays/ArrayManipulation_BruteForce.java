package arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * 
 * @author sam
 *
 */
public class ArrayManipulation_BruteForce {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int count = sc.nextInt();
		int[] arr = new int[length];
		sc.nextLine();

		int start =0, end = 0, num = 0;
		while (count-- > 0) {
			start = sc.nextInt();
			end = sc.nextInt();
			num = sc.nextInt();
			for(int i = start; i <=end; i++){
				arr[i-1] += num;
			}
			sc.nextLine();
		}
		
		int max = Arrays.stream(arr).max().getAsInt();
		System.out.println(max);
		sc.close();

	}
}