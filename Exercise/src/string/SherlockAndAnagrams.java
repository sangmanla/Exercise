package string;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 * 
 */
public class SherlockAndAnagrams {
	static int sherlockAndAnagrams(String s) {
		ArrayList<int[]> subs = findAllSubString(s);
		int cnt = findAnagrams(subs);
		return cnt;
	}

	private static int findAnagrams(ArrayList<int[]> subs) {
		int cnt = 0;
		for (int a = 0; a < subs.size(); a++) {
			int[] al = subs.get(a);
			for (int b = a + 1; b < subs.size(); b++) {
				if(checkAnagrams(al, subs.get(b))){
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static boolean checkAnagrams(int[] al, int[] is) {
		for(int i=0;i<26;i++){
			if(al[i] != is[i]) return false;
		}
		return true;
	}

	private static ArrayList<int[]> findAllSubString(String s) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int i = 1; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (j < s.length() && j + i <= s.length()) {
					list.add(getAlpha(s.substring(j, j + i)));
				} else {
					break;
				}
			}
		}
		return list;
	}

	private static int[] getAlpha(String substring) {
		int[] alpha = new int[26];
		for(char c : substring.toCharArray()) alpha[c-'a']++;
		return alpha;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();
			int result = sherlockAndAnagrams(s);
			System.out.println(result);
		}
		in.close();
	}
}
