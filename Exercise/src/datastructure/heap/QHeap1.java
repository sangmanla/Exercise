package datastructure.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/qheap1/problem
 * @author sam
 *
 */
public class QHeap1 {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		scan.nextLine();
		
		for(int i=0;i<count;i++){
			String in = scan.nextLine();
			if(in.startsWith("3")){
				System.out.println(pq.peek());
			}else if(in.startsWith("2")){
				pq.remove(Integer.parseInt(in.split(" ")[1]));
			}else{
				pq.offer(Integer.parseInt(in.split(" ")[1]));
			}
		}
		scan.close();
	}
}
