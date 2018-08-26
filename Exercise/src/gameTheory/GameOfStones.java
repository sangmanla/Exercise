package gameTheory;

import java.util.Scanner;

public class GameOfStones {

	/**
	 * https://www.hackerrank.com/challenges/game-of-stones-1/problem
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < cnt; i++) {
			int num = Integer.parseInt(scan.nextLine());
			System.out.println(num % 7 < 2 ? "Second" : "First");
		}
		scan.close();
	}
}
