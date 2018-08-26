package gameTheory;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/nim-game-1/problem
 * @author sam
 */
public class NimGame {
	final static String FIRST = "First", SECOND = "Second";
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int gameCnt = Integer.parseInt(scan.nextLine());
		for(int i=0;i<gameCnt;i++){
			scan.nextLine();
			String[] strs = scan.nextLine().split(" ");

			int result = 0;
			for(int j=0;j<strs.length;j++){
				result ^= Integer.parseInt(strs[j]);
			}
			
			if(result == 0){
				System.out.println(SECOND);
			}else{
				System.out.println(FIRST);
			}
		}
		scan.close();
	}
}