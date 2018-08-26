package datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 * @author sam
 */
public class BalancedBrackets {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = Integer.parseInt(scan.nextLine());
		while(cnt-- > 0){
			String str = scan.nextLine();
			String result = "YES";
			if(str.length()%2!=0) result = "NO";
			else{
				char[] chs = str.toCharArray();
				Stack<Character> s = new Stack<Character>();
				for(char c : chs){
					if(s.isEmpty() || isOpenChar(c)) s.push(c);
					else if(comp(s.peek(), c)){
						s.pop();
					}else{
						result = "NO";
						break;
					}
				}
				if(!s.isEmpty()) result = "NO";
			}
			System.out.println(result);
		}
		scan.close();
	}
	
	private static boolean isOpenChar(char a){
		if(a == '[' || a == '{' || a =='(') return true;
		else return false;
	}
	
	private static boolean comp(char a, char b){
		if(a == '{' && b == '}') return true;
		else if(a == '(' && b == ')') return true;
		else if(a == '[' && b == ']') return true;
		else return false;
	}
}