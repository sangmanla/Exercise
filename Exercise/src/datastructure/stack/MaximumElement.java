package datastructure.stack;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/maximum-element/problem
 * @author sam
 *
 */
public class MaximumElement {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
		Scanner scan = new Scanner(System.in);
		int cnt = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < cnt; i++) {
			String in = scan.nextLine();
			if ("2".equals(in)) {
				int delVal = s.pop();
				pq.remove(delVal);
			} else if ("3".equals(in)) {
				System.out.println(pq.peek());
			} else {
				int newVal = Integer.parseInt(in.split(" ")[1]);
				s.push(newVal);
				pq.offer(newVal);
			}
		}
		scan.close();
	}
}
