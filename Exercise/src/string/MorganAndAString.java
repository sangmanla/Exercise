package string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/morgan-and-a-string/problem
 * @author sam
 * 
 */
public class MorganAndAString {
	static int alen = 0, blen = 0;
	static int idx1 = 0, idx2 = 0;
	static char[] aa = null, bb = null;
	static StringBuffer result = null;

	static String morganAndString(String a, String b) {
		aa = a.toCharArray();
		bb = b.toCharArray();
		alen = aa.length;
		blen = bb.length;

		result = new StringBuffer();
		idx1 = 0;
		idx2 = 0;
		while (idx1 != alen - 1 && idx2 != blen) {
			if (aa[idx1] < bb[idx2]){
				result.append(aa[idx1]);
				idx1++;
			}else if(aa[idx1] > bb[idx2]){
				result.append(bb[idx2]);
				idx2++;
			}else{
				checkSame();
			}
			
			if(idx1 >= alen || idx2 >= blen) break;
			
		}
		if (idx1 < alen)
			result.append(Arrays.copyOfRange(aa, idx1, alen));
		if (idx2 < blen)
			result.append(Arrays.copyOfRange(bb, idx2, blen));
		return result.toString();
	}

	private static void checkSame() {
		int i = idx1, j = idx2;
		char prev = aa[idx1];
		
		for (; i < alen && j < blen; i++, j++) {
			if (aa[i] != bb[j]) break;
			else{
				if (prev < aa[i]) {
					result.append(Arrays.copyOfRange(aa, idx1, i)).append(Arrays.copyOfRange(bb, idx2, j));
					idx1 = i; 
					idx2 = j;
					prev = aa[i];
				}
			}
		}
		
		if(i == alen){
			result.append(bb[idx2]);
			idx2++;
		}else if (j == blen){
			result.append(aa[idx1]);
			idx1++;
		}else{
			if(aa[i] < bb[j]){
				result.append(aa[idx1]);
				idx1++;
			}else{
				result.append(bb[idx2]);
				idx2++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String a = in.next();
			String b = in.next();
			String result = morganAndString(a, b);
			System.out.println(result);
		}
		in.close();
	}
}
