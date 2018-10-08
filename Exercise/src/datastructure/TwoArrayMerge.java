package datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class TwoArrayMerge {

    public static void main(String[] args) {
	int[] a1 = {1,3,5,7,2,4,6,23};
	int[] a2 = {3,4,1,23,5,3,2,6,7};
	Arrays.sort(a1); // O(nlog(n))
	Arrays.sort(a2); // O(nlog(n))
	int[] result = new int[a1.length + a2.length];
	
	int idx1 = 0, idx2 = 0, resultIdx = 0;
	while(idx1 < a1.length && idx2 < a2.length){ // O(n)
	    if(a1[idx1] < a2[idx2]){
		result[resultIdx] = a1[idx1];
		idx1++;
	    }else if(a1[idx1] > a2[idx2]){
		result[resultIdx] = a2[idx2];
		idx2++;
	    }else{
		result[resultIdx] = a1[idx1];
		resultIdx++;
		result[resultIdx] = a2[idx2];
		idx1++;
		idx2++;
	    }
	    resultIdx++;
	}
	
	Arrays.stream(result).forEach(x -> System.out.print(x + ","));
    }
}
