package arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class NewYearChaos {

    /**
     * https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
     * 
     * @param args
     */
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int testCase = Integer.parseInt(scan.nextLine());

	IntStream.range(0, testCase).forEach(x -> {
	    test(scan);
	});
	scan.close();
    }

    private static void test(Scanner scan) {
	scan.nextLine();
	int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();

	int cnt = 0;
	for (int i = nums.length - 1; i >= 0; i--) {
	    int num = i + 1;

	    if (num > nums[i]) {
		if(i-1 >=0  && nums[i-1] == num){
		    swap(nums, i, i-1);
		    cnt++;
		} else if(i-2 >=0  && nums[i-2] == num){
		    swap(nums, i-2, i-1);
		    swap(nums, i-1, i);
		    cnt+=2;
		}else{
		    System.out.println("Too chaotic");
		    return;
		}
	    }
	}
	System.out.println(cnt);
    }

    private static void swap(int[] nums, int i, int j) {
	int tmp = nums[i];
	nums[i] = nums[j];
	nums[j] = tmp;
    }
}