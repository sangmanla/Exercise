package gameTheory;

import java.util.Scanner;

public class PockerNim1 {
	/**
	 * https://www.hackerrank.com/challenges/poker-nim-1/problem
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = scan.nextInt();
		while(cnt-- > 0){
			int pile = scan.nextInt();
			int times = scan.nextInt();
			int xor = 0;
			for(int i=0;i<pile;i++){
				xor ^= scan.nextInt();
			}
			System.out.println(xor == 0?"Second":"First");
		}
		scan.close();
	}
}