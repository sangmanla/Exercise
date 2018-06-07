package greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/board-cutting/problem
 * @author sam
 *
 */
public class CuttingBoards {
	// Complete the boardCutting function below.
    static int boardCutting(int[] arrayY, int[] arrayX) {
    	long cost = 0;
    	int sizeX = arrayX.length, sizeY = arrayY.length, xDiv = 1, yDiv = 1;
    	
    	arrayY = reverseSort(arrayY);
    	arrayX = reverseSort(arrayX);
    	
    	while(sizeX>0 || sizeY>0){
    		if((sizeX>0 && sizeY == 0) || ((sizeX>0) && (arrayX[xDiv-1] > arrayY[yDiv-1]) )){
    			cost += yDiv * (long)arrayX[xDiv-1];
    			xDiv++;
    			sizeX--;
    		}else if(sizeY>0){
    			cost += xDiv * (long)arrayY[yDiv-1];
    			yDiv++;
    			sizeY--;
    		}
    		cost = gm(cost);
    	}
    	return (int)gm(cost);
    }
    
    static int[] reverseSort(int[] arr){
    	Arrays.sort(arr);
    	return IntStream.of(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
    }
    
    static long gm(long cost){
    	return cost % ((int)Math.pow(10, 9) + 7);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = Integer.parseInt(scanner.nextLine());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] mn = scanner.nextLine().split(" ");

            int m = Integer.parseInt(mn[0]);
            int n = Integer.parseInt(mn[1]);
            int[] cost_y = new int[m-1];

            String[] cost_yItems = scanner.nextLine().split(" ");

            for (int i = 0; i < m-1; i++) {
                int cost_yItem = Integer.parseInt(cost_yItems[i]);
                cost_y[i] = cost_yItem;
            }

            int[] cost_x = new int[n-1];
            String[] cost_xItems = scanner.nextLine().split(" ");

            for (int i = 0; i < n-1; i++) {
                int cost_xItem = Integer.parseInt(cost_xItems[i]);
                cost_x[i] = cost_xItem;
            }

            System.out.println(boardCutting(cost_y, cost_x));
        }

        scanner.close();
    }
}