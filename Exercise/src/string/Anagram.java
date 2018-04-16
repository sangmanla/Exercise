package string;

import java.util.Scanner;

/**
 * URL : https://www.hackerrank.com/challenges/anagram/problem
 * Sample Input -------------------- 
 * 6
aaabbb
ab
abc
mnop
xyyx
xaxbbbxx
 *
 * Sample Output -------------------
 * 3
1
-1
2
0
1
 * @author sam
 *
 */
public class Anagram {

	static int anagram(String s){
		
        if(s.length() % 2 != 0) return -1;
        else{
        	int cnt=0;
        	int[] alpha = new int[26];
        	char[] cs = s.toCharArray();
        	for(int i=0;i<cs.length/2;i++){
        		alpha[cs[i]-'a']++;
        	}
        	
        	for(int i=cs.length/2;i<cs.length;i++){
        		alpha[cs[i]-'a']--;
        	}
        	
        	for(int a : alpha){
        		if(a > 0) cnt+=a;
        	}
        	
        	return cnt;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = anagram(s);
            System.out.println(result);
        }
        in.close();
    }
}
