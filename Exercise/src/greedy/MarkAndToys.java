package greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/mark-and-toys/problem
 * @author sam
 *
 */
public class MarkAndToys {

	// Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
    	Arrays.parallelSort(prices);
    	
    	int cnt = 0;
    	for(int price : prices){
    		if(k >= price){
    			k -= price;
    			cnt++;
    		}else{
    			break;
    		}
    	}
    	
    	return cnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");
        
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] prices = new int[n];
        
        String[] pricesItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        System.out.println(maximumToys(prices, k));
        scanner.close();
    }
}
