package datastructure.heap;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/jesse-and-cookies/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 * 
 * @author sam
 *
 */
public class JesseandCookies {
	/*
	 * Complete the cookies function below.
	 */
	static int cookies(int k, int[] arr) {
		int cnt = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		Arrays.stream(arr).forEach(q::add);
		while(q.peek() < k){
			if(q.size() == 1 && q.peek() < k) return -1;
			q.add(q.poll() + q.poll() * 2);
			cnt++;
		}
		
		return cnt;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0].trim());

		int k = Integer.parseInt(nk[1].trim());

		int[] A = new int[n];

		String[] AItems = scanner.nextLine().split(" ");

		for (int AItr = 0; AItr < n; AItr++) {
			int AItem = Integer.parseInt(AItems[AItr].trim());
			A[AItr] = AItem;
		}

		int result = cookies(k, A);

		System.out.println(result);
	}
}
