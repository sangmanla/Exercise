import java.util.*;

public class Solution5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt(), avg = num / 4;
		String gene = scan.next();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 0);
		map.put('T', 0);
		map.put('G', 0);
		
		for(char c : gene.toCharArray()) map.put(c, map.get(c) + 1);
		
		int left = 0, right = 0, min = Integer.MAX_VALUE;
		
		while(right < num - 1){
			char rc = gene.charAt(right++);
			map.put(rc, map.get(rc) - 1);
			while(steady(map, avg)){
				min = Math.min(min, right-left);
				char lc = gene.charAt(left++);
				map.put(lc, map.get(lc)+1);
			}
		}
		
		System.out.println(min);
		scan.close();
	}

	private static boolean steady(Map<Character, Integer> map, int avg) {
		for(int i : map.values()){
			if(avg < i) return false;
		}
		return true;
	}
}