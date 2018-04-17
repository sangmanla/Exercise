package string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/common-child/problem
 * @author sam
 *
 */
public class CommonChild {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();
		int result = commonChild(s1, s2);
		System.out.println(result);
		in.close();
	}

	private static int commonChild(String s1, String s2) {
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i=0;i<=s1.length();i++){
			for(int j=0;j<=s2.length();j++){
				if(i == 0 || j== 0){
					dp[i][j] = 0;
				}else{
					if(s1.charAt(i-1) == s2.charAt(j-1)){
						dp[i][j] = dp[i-1][j-1] + 1;
					}else{
						dp[i][j] = Integer.max(dp[i][j-1], dp[i-1][j]);
					}
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
}