package bitManipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sum-vs-xor/problem
 * @author sam
 */
public class SumVsXOR {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long num = Long.parseLong(scan.nextLine());
		
		if(num == 0) System.out.println(1);
		else{
			char[] bins = Long.toBinaryString(num).toCharArray();
			
			int cnt = 0;
			for(char c : bins){
				if(c == '0') cnt++;
			}
			
			System.out.println((long)Math.pow(2, cnt));
		}
        
		scan.close();
	}
}