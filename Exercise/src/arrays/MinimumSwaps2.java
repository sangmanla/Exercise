package arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * 
 * @author sam
 *
 */
public class MinimumSwaps2 {

    static int cnt = 0, tmp = 0;

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	scan.nextLine();
	int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
	int[] copy = Arrays.copyOf(nums, nums.length);
	Arrays.sort(copy);

	IntStream.range(0, copy.length).forEach(x -> {
	    if (copy[x] != nums[x]) {
		for (int i = x; i < nums.length; i++) {
		    if (copy[x] == nums[i]) {
			tmp = nums[i];
			nums[i] = nums[x];
			nums[x] = tmp;
			cnt++;
			break;
		    }
		}
	    }
	});

	System.out.println(cnt);
	scan.close();
    }
}