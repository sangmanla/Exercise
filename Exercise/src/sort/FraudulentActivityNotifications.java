package sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 * 
 * @author sam
 */
//
public class FraudulentActivityNotifications {
    static int activityNotifications(int[] expenditure, int d) {
	int notificationCnt = 0;
	List<Integer> arr = Arrays.stream(expenditure).limit(d).boxed().sorted().collect(Collectors.toList());

	for (int i = d; i < expenditure.length; i++) {
	    double median = getMedian(arr);
	    if (i >= d && (median * 2) <= expenditure[i]) {
		notificationCnt++;
	    }
	    remove(arr, expenditure[i - d]);
	    add(arr, expenditure[i]);
	}
	return notificationCnt;
    }

    private static void add(List<Integer> arr, int addNum) {
	int middle = arr.size()/2, start = 0, end = arr.size();
	
	while(true){
	    int temp = arr.get(middle);

	    if(temp == addNum || end-start<=2){
		arr.add(middle+1, addNum);
		break;
	    }else if(temp < addNum){
		start = middle;
		middle = (start + end)/2;
	    }else if(temp > addNum){
		end = middle;
		middle = (start + end)/2;
	    }
	}
    }
    
    private static void remove(List<Integer> arr, int removeNum) {
	int pos = Collections.binarySearch(arr, removeNum);
	
	try{
	    arr.remove(pos);
	}catch(Exception e){
	    e.printStackTrace();
	}
	
    }

    private static double getMedian(List<Integer> arr) {
	if (arr.size() % 2 == 0) {
	    return (arr.get(arr.size() / 2 - 1) + arr.get(arr.size() / 2)) / 2.0;
	} else
	    return arr.get(arr.size() / 2);
    }

    public static void main(String[] args) throws IOException {
	Scanner scanner = new Scanner(System.in);
	String[] nd = scanner.nextLine().split(" ");

	int n = Integer.parseInt(nd[0]);
	int d = Integer.parseInt(nd[1]);
	int[] expenditure = new int[n];

	String[] expenditureItems = scanner.nextLine().split(" ");

	for (int i = 0; i < n; i++) {
	    int expenditureItem = Integer.parseInt(expenditureItems[i]);
	    expenditure[i] = expenditureItem;
	}

	System.out.println(activityNotifications(expenditure, d));

	scanner.close();
    }
}
