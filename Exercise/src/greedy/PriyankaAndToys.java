package greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/priyanka-and-toys/problem
 * @author sam
 *
 */
public class PriyankaAndToys {

	// Complete the toys function below.
	static int toys(int[] w) {
		Arrays.sort(w);
		
		int containerCnt = 1, prev = 0;
		
		for(int i=0;i<w.length;i++){
			int itemWeight = w[i];
			if(i==0) {
				prev = itemWeight;
			}else{
				if(itemWeight > prev+4){
					prev = itemWeight;
					containerCnt++;
				}
			}
		}
		return containerCnt;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(scanner.nextLine());

		int[] w = new int[n];

		String[] wItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int wItem = Integer.parseInt(wItems[i]);
			w[i] = wItem;
		}

		System.out.println(toys(w));

		scanner.close();
	}
}
