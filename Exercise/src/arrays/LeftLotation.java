package arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * 
 * @author sam
 *
 */
public class LeftLotation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int lotationCnt = sc.nextInt();
		sc.nextLine();

		String[] nums = sc.nextLine().split(" ");
		int startIdx = 0;

		if (lotationCnt >= count) {
			startIdx = count - (count % lotationCnt);
		} else {
			startIdx = lotationCnt;
		}

		for (int i = startIdx; i < count; i++) {
			System.out.print(nums[i] + " ");
		}

		for (int i = 0; i < startIdx; i++) {
			System.out.print(nums[i] + " ");
		}

		sc.close();
	}
}
