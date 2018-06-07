package greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maximum-perimeter-triangle/problem
 * @author sam
 *
 */
public class MaximumPerimeterTriangle {

	// Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(int[] sticks) {
    	int[] result = new int[3];
    	Arrays.sort(sticks);
    	
    	for(int i=sticks.length-1;i>=2;i--){
    		result[0] = sticks[i];
    		result[1] = sticks[i-1];
    		result[2] = sticks[i-2];
    		if(result[1]+result[2] > result[0] && result[0]!=0 && result[1]!=0 && result[2]!=0){
    			return result;
    		}
    	}
    	
    	int[] na = {-1};
    	return na;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(scanner.nextLine());

        int[] sticks = new int[n];

        String[] sticksItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int sticksItem = Integer.parseInt(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        int[] result = maximumPerimeterTriangle(sticks);

        Arrays.stream(result).sorted().forEach(v -> System.out.print(v + " "));

        scanner.close();
    }
}
