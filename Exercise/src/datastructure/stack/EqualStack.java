package datastructure.stack;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/equal-stacks/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * @author sam
 */
public class EqualStack {

	static int equalStacks(int[] h1, int[] h2, int[] h3) {
		int[][] stacks = {h1, h2, h3};
        int sum[] = {
        	Arrays.stream(h1).sum(),
        	Arrays.stream(h2).sum(),
        	Arrays.stream(h3).sum()
        };
        
        int[] index = new int[3];
        
        while(!equal(sum)){
        	int maxSum = Arrays.stream(sum).max().getAsInt();
        	IntStream.range(0, 3).forEach(i->{
        		if(sum[i] == maxSum){
        			sum[i] -= stacks[i][index[i]];
        			index[i] = index[i] + 1;
        		}
        	});
        }
        
        return sum[0];
    }
	

	private static boolean equal(int[] sum) {
		return (sum[0] == sum[1] && sum[1] == sum[2]);
	}



    public static void main(String[] args) throws IOException {
    	Scanner scanner = new Scanner(System.in);
    	
    	String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);
        
        System.out.println(result);
        
    	scanner.close();
    }

}
