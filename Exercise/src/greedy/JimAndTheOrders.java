package greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 * https://www.hackerrank.com/challenges/jim-and-the-orders/problem
 */
public class JimAndTheOrders {

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
    	int[] result = new int[orders.length];
    	int[] sums = new int[orders.length];
    	int temp = 0;
    	
    	for(int i=0;i<orders.length;i++){
    		sums[i] = orders[i][0] + orders[i][1];
    		result[i] = i+1;
    	}
    	
    	for(int i=0;i<sums.length;i++){
    		for(int j=i;j<sums.length;j++){
    			if(sums[i]>sums[j]){
    				temp = sums[j];
    				sums[j] = sums[i];
    				sums[i] = temp;
    				temp = result[j];
    				result[j] = result[i];
    				result[i] = temp;
    			}else if(sums[i]== sums[j] && result[i] > result[j]){
    				temp = result[j];
    				result[j] = result[i];
    				result[i] = temp;
    			}
    		}
    	}
    	
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scanner.nextLine());

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        Arrays.stream(jimOrders(orders)).forEach(s -> System.out.print(s + " "));
        scanner.close();
    }
}
