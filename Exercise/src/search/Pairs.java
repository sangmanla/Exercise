package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/pairs/problem
 * @author sam
 *
 */
public class Pairs {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstLine[] = scan.nextLine().split(" ");
		int target = Integer.parseInt(firstLine[1]);
		int result = 0;
		int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).sorted().toArray();
		
		int smaller = 0, bigger = 0;
		for(int i=0;i<nums.length;i++){
			smaller = nums[i];
			for(int k=i+1;k<nums.length;k++){
				bigger = nums[k];
				int diff = bigger - smaller;
				if(diff > target) break;
				else if(diff == target) {
					result++;
					break;
				}
			}
		}
		
		System.out.println(result);
		scan.close();
	}
}
