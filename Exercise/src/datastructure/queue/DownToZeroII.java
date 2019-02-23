package datastructure.queue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/down-to-zero-ii/problem
 * @author sam
 *
 */
public class DownToZeroII {

    /*
     * Complete the downToZero function below.
     */
	static int[] mins = new int[1000001];
    static int downToZero(int n) {
        if(n <= 3) {
        	return n;
        }else if(mins[n] !=0 ){
        	return mins[n];
		} else {
			int min = Integer.MAX_VALUE;
			for(int i=2;i<=Math.sqrt(n);i++){
				if(n%i == 0) min = Math.min(min, 1 + downToZero(n / i));	
			}
			int result = Math.min(min, 1 + downToZero(n - 1));
			mins[n] = result;
        	return result;
        }
    }
    
    List<Integer> temp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    	Scanner scanner = new Scanner(System.in);
    	
        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = downToZero(n);
            System.out.println(result);
        }

        scanner.close();
    }
}