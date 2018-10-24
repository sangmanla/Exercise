package sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/lilys-homework/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * @author sam
 *
 */
public class LilysHomework {

    public static void main(String[] args) throws IOException {
	Scanner scan = new Scanner(System.in);
	int n = Integer.parseInt(scan.nextLine());
	Integer[] arr = new Integer[n];
	String[] arrItems = scan.nextLine().split(" ");
	for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        System.out.println(lilysHomework(arr));
	
	scan.close();
    }

    private static int lilysHomework(Integer[] arr) {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>(), descMap = new HashMap<Integer, Integer>();
	for(int i=0;i<arr.length;i++){
	    map.put(arr[i], i);
	}

	descMap.putAll(map);
	
	Integer[] sortedArray = Arrays.copyOf(arr, arr.length); 
	Arrays.sort(sortedArray);
	
	int result1 = getCount(Arrays.copyOf(arr, arr.length), descMap, sortedArray);
	Arrays.sort(sortedArray, Collections.reverseOrder());
	
	int result2 = getCount(arr, map, sortedArray);
	return Math.min(result1, result2);
    }
    
    private static int getCount(Integer[] arr, Map<Integer, Integer> map, Integer[] sortedArray) {
	int count = 0;
	
	for(int i=0;i<arr.length;i++){
	    int snum = sortedArray[i];
	    if(snum != arr[i]){
		count++;
		
		int swapIndex = map.get(snum);
		
		arr[swapIndex] = arr[i];
		arr[i] = snum;
		
		map.put(arr[swapIndex], swapIndex);
		map.put(arr[i], i);
	    }
	}
	return count;
    }
}
