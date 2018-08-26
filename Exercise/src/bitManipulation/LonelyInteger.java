package bitManipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-lonely-integer/problem?h_r=internal-search
 * 
 * @author sam
 */
public class LonelyInteger {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		String[] nums = scan.nextLine().split(" ");
		int[] cnt = new int[101];
		
		for(int i=0;i<num;i++){
			cnt[Integer.parseInt(nums[i])]++;
		}
		
		for(int i=0;i<cnt.length;i++){
			if(cnt[i] == 1) {
				System.out.println(i);
				break;
			}
		}
		
		scan.close();
	}

}
