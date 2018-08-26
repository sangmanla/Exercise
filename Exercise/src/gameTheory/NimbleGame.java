package gameTheory;

import java.util.Scanner;

public class NimbleGame {

	/**
	 * https://www.hackerrank.com/challenges/nimble-game-1/problem
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = Integer.parseInt(scan.nextLine());
		for(int i=0;i<cnt;i++){
			int oddCnt = 0;
			scan.nextLine();
			String[] nums = scan.nextLine().split(" ");
			for(int k=0;k<nums.length;k++){
				if(Integer.parseInt(nums[k]) % 2 == 1) {
					oddCnt^=k;
				}
			}
			System.out.println(oddCnt==0?"Second":"First");
		}
		scan.close();
	}
}