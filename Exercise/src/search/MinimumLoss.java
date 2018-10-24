package search;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/minimum-loss/problem
 * 
 * @author sam
 *
 */
public class MinimumLoss {
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int count = scan.nextInt();
	TreeSet<Long> values = new TreeSet<>();
	values.add(scan.nextLong());
	long minLoss = Long.MAX_VALUE;
	for (int i = 1; i < count; i++) {
	    long value = scan.nextLong();
	    Long higher = values.higher(value);
	    if (higher != null) {
		minLoss = Math.min(minLoss, Math.abs(higher - value));
	    }
	    values.add(value);
	}
	System.out.println(minLoss);
	scan.close();
    }
}