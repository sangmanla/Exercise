package datastructure.heap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/find-the-running-median/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * 
 * @author sam
 *
 */
public class FindtheRunningMedian {

	/*
	 * Complete the runningMedian function below.
	 */
	static double[] runningMedian(int[] a) {
		List<Integer> list = new ArrayList<Integer>();
		double[] result = new double[a.length];
		
		for (int i = 0; i < a.length; i++) {
			insertNew(list, a[i], 0, list.size());
			int size = list.size();
			if(size % 2 == 0){
				result[i] = ((double) list.get((size / 2) - 1) + (double) list.get((size / 2))) / 2;
			}else{
				result[i] = list.get(size / 2);
			}
		};
		return result;
	}
	

	private static void insertNew(List<Integer> list, int x, int firstIdx, int lastIdx) {
		if(firstIdx == lastIdx){
			list.add(firstIdx, x);
		}else{
			int middleIdx = (firstIdx + lastIdx)/2;
			int first = list.get(firstIdx);
			int last = list.get(lastIdx-1);
			int middle = list.get(middleIdx);
			if(first > x) {
				list.add(firstIdx, x);
			}else if(last < x){
				list.add(lastIdx, x);
			}else if(x > middle){
				insertNew(list, x, middleIdx, lastIdx);
			}else if(x < middle){
				insertNew(list, x, firstIdx, middleIdx);
			}else if(x == middle){
				list.add(middleIdx, x);
			}
		}
	}


	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int aCount = Integer.parseInt(scanner.nextLine().trim());

		int[] a = new int[aCount];

		for (int aItr = 0; aItr < aCount; aItr++) {
			int aItem = Integer.parseInt(scanner.nextLine().trim());
			a[aItr] = aItem;
		}

		double[] result = runningMedian(a);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			System.out.print(result[resultItr]);

			if (resultItr != result.length - 1) {
				System.out.println();
			}
		}

		System.out.println();

		scanner.close();
	}
}
