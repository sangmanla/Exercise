package greedy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-the-beast/problem
 * @author sam
 *
 */
public class SherlockAndTheBeast {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = Integer.parseInt(scanner.nextLine());
		int five = 0, three = 0;
		for (int tItr = 0; tItr < t; tItr++) {
			five = Integer.parseInt(scanner.nextLine());
			three = 0;
			boolean find = false;
			while(!find){
				if(five%3 == 0 && three % 5 == 0) {
					find=true;
					print(five, three);
					break;
				}else{
					int min = Math.min(five%3, three%5);
					if(min == 0) min = 1;
					five-=min;
					three+=min;
				}
				if(five < 0) break;
			}
			if(!find) System.out.println(-1);
		}
		scanner.close();
	}

	private static void print(int five, int three) {
		StringBuffer result = new StringBuffer();
		for(int i=0;i<five;i++) result.append(5);
		for(int i=0;i<three;i++) result.append(3);
		System.out.println(result);
		
	}
}