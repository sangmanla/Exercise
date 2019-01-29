package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * 
 * @author sam
 */
public class RansomNote {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Scanner scan = new Scanner(System.in);
		try {
			scan.nextLine();
			Arrays.stream(scan.nextLine().split(" ")).forEach(x -> {
				map.put(x, map.get(x) == null ? 1 : map.get(x) + 1);
			});
			String[] searchKey = scan.nextLine().split(" ");
			for(String x : searchKey){
				if (map.get(x) == null || map.get(x) == 0) {
					System.out.println("No");
					return;
				} else {
					map.put(x, map.get(x) - 1);
				}
			}
			System.out.println("Yes");
		} finally {
			scan.close();
		}
	}
}
