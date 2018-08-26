package gameTheory;

import java.util.Scanner;

public class AChessboardGame {

	/**
	 * https://www.hackerrank.com/challenges/a-chessboard-game-1/problem
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		while (num-- > 0) {
			int x = scan.nextInt() % 4;
			int y = scan.nextInt() % 4;
			System.out.println((y == 0) || (y == 3) || (x == 0) || (x == 3) ? "First" : "Second");
		}
		scan.close();
	}
}