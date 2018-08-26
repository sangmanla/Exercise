package gameTheory;

import java.util.Scanner;

public class TowerBreakers {

	/**
	 * https://www.hackerrank.com/challenges/tower-breakers-1/problem
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < cnt; i++) {
			String[] arr = scan.nextLine().split(" ");
			if (Integer.parseInt(arr[1]) == 1 || Integer.parseInt(arr[0]) % 2 == 0)
				System.out.println(2);
			else
				System.out.println(1);
		}
		scan.close();
	}
}