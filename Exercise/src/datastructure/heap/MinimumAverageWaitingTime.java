package datastructure.heap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/minimum-average-waiting-time/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&h_r=next-challenge&h_v=zen
 * 
 * @author sam
 *
 */
public class MinimumAverageWaitingTime {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		scanner.nextLine();

		List<Order> list = new ArrayList<Order>();

		for (int customersRowItr = 0; customersRowItr < n; customersRowItr++) {
			String[] customersRowItems = scanner.nextLine().split(" ");
			Order order = new Order(Integer.parseInt(customersRowItems[0]), Integer.parseInt(customersRowItems[1]));
			list.add(order);
		}
		
		list = list.stream().sorted((x, y) -> {
			if(x.start > y.start) return 1;
			else return -1;
		}).collect(Collectors.toList());

		long total = 0, cumulatedTime = list.get(0).start;
		Queue<Order> queue = new PriorityQueue<>();
		int idx = 1;
		queue.add(list.get(0));
		while(list.size() > idx || !queue.isEmpty()){
			while(list.size() > idx && list.get(idx).start <= cumulatedTime){
				queue.add(list.get(idx));
				idx++;
			}
			Order cur = queue.poll();
			if(cur!=null){
				total += (cumulatedTime > cur.start? (cumulatedTime - cur.start) : 0) + cur.duration;
				cumulatedTime += cur.duration;
			}else{
				queue.add(list.get(idx));
				idx++;
			}
		}
		System.out.println(total/n);
		scanner.close();
	}
}

class Order implements Comparable<Order> {
	Order(int s, int du) {
		this.start = s;
		this.duration = du;
	}

	int start;
	int duration;

	@Override
	public int compareTo(Order o) {
		if (this.duration > o.duration)
			return 1;
		return -1;
	}
}
