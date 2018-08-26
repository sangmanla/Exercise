package sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/big-sorting/problem
 * @author sam
 */
public class BigSorting {

    public static void main(String[] args) throws IOException {
    	Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        
        String[] unsorted = new String[n];
        for (int i = 0; i < n; i++) {
            unsorted[i] = scanner.nextLine();
        }
        
        scanner.close();
        
        Arrays.sort(unsorted, (left, right) -> {
        	if(left.length()!=right.length()) return left.length() - right.length();
        	else return left.compareTo(right);
        });
        
        System.out.println(String.join(System.lineSeparator(), unsorted));
    }
}
