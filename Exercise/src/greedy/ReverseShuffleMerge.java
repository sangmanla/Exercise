package greedy;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/reverse-shuffle-merge/problem
 * @author sam
 */
public class ReverseShuffleMerge {

	// Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
    	StringBuffer result = new StringBuffer();
    	s = reverse(s);
    	
    	System.out.println(s);
    	
    	char[] cs = s.toCharArray();
    	double[] cnts = new double[26];
    	
    	for(char c : cs){
    		cnts[c-'a']+=0.5;
    	}
    	
    	while(check(cnts)){
    		for(int i=0;i<cnts.length;i++){
    			double d = cnts[i];
    			if(d==0) continue;
    			else{
    				cnts[i]--;
    				char ch = gc(i);
    				String checkS = s.substring(s.indexOf(ch)+1, s.length());
    				if(d!=0 && check_s_possibility(checkS, cnts)){
    					s = checkS;
    					result.append(ch);
    					break;
    				}else{
    					cnts[i]++;
    				}
    			}
    		}
    	}
    	
    	return result.toString();
    }
    
    private static boolean check_s_possibility(String checkS, double[] cnts) {
    	double[] charCnts = new double[26];
    	for(char c : checkS.toCharArray()){
    		charCnts[c-'a']+=1;
    	}
    	
    	for(int i=0;i<26;i++){
    		if(charCnts[i]<cnts[i]) return false;
    	}
		return true;
	}
    
    private static char gc(int i){
    	char ch = 'a';
    	ch += i;
    	return ch;
    }

	private static boolean check(double[] cnts) {
		for(double d : cnts){
			if(d>0) return true;
		}
		return false;
	}

	public static String reverse(String str){
    	return (new StringBuffer(str)).reverse().toString();
    }


    public static void main(String[] args) throws IOException {
    	Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(reverseShuffleMerge(s));
        scanner.close();
    }

}
