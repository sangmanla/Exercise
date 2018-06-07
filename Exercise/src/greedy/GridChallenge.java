package greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/grid-challenge/problem
 * @author sam
 *
 */
public class GridChallenge {

    // Complete the gridChallenge function below.
    static String gridChallenge(String[] grid) {

    	for(int i=0;i<grid.length;i++){
    		char[] chs = grid[i].toCharArray();
    		Arrays.sort(chs);
    		grid[i] = String.copyValueOf(chs);
			for(int j=0;j<grid[i].length() && i!=0;j++){
				if(grid[i].charAt(j) < grid[i-1].charAt(j)) return "NO";
			}
    	}
    	return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

    	int t = Integer.parseInt(scanner.nextLine());
    	String result = "";
    	
    	for(int k=0;k<t;k++){
	        int n = Integer.parseInt(scanner.nextLine());
	
	        String[] grid = new String[n];
	
	        for (int i = 0; i < n; i++) {
	            String gridItem = scanner.nextLine();
	            grid[i] = gridItem;
	        }
	
	        result += gridChallenge(grid) + System.lineSeparator();
    	}
    	System.out.println(result);
        scanner.close();
    }
}
