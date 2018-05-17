package search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem
 * @author sam
 *
 */
public class HackerlandRadioTransmitters {
	static int hackerlandRadioTransmitters(int[] x, int width) {
		int result = 0;
		Arrays.sort(x);
		
		for(int i=0;i<x.length;i++){
			int idx = i;
			while(i<x.length && x[i] - width <= x[idx]){
				i++;
			}
			i--;
			idx = i;
			while(i<x.length && x[idx] + width >= x[i]){
				i++;
			}
			i--;
			result++;
		}
		
		return result;
    }

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i = 0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        int result = hackerlandRadioTransmitters(x, k);
        System.out.println(result);
        in.close();
    }
}
