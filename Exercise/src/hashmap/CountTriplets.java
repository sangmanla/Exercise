package hashmap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps&h_r=next-challenge&h_v=zen
 * 
 * @author sam
 *
 */
public class CountTriplets {

	// Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {
		Map<Long, Long> v2 = new HashMap<>();
		Map<Long, Long> v3 = new HashMap<>();
		Long count = 0L;
		for (Long k : arr) {
			v3.compute(k * r, (key, value) -> value != null ? value + v2.get(k) : v2.get(k));
			v2.compute(k * r, (key, value) -> value == null ? 1 : value + 1);
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();
		long com = scan.nextLong();
		List<Long> list = new ArrayList<Long>();
		long tmp = 0l;
		while (len-- > 0) {
			tmp = scan.nextLong();
			if (tmp == 1 || tmp % com == 0)
				list.add(tmp);
		}
		System.out.println(countTriplets(list, com));
		scan.close();
	}
}
