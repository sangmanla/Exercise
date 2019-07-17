package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * @author sam
 */
public class FrequencyQueries {
	static Map<Integer, Integer> map = new HashMap<>(1024);
	static Map<Integer, Integer> trackMap = new HashMap<>(1024);
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int count = scan.nextInt();
        
        while (count > 0) {
            int key = scan.nextInt(), val = scan.nextInt();
            int before = check(val);
            if (key == 1) {
                int after = before + 1;
                map.put(val, after);
                saveTrack(before, after);
            } else if (key == 2) {
                int after = before - 1;
				if (after > 0) {
					map.put(val, after);
				} else {
					map.remove(val);
				}
                saveTrack(before, after);
            } else if (key == 3) {
            	sb.append(trackMap.containsKey(val) ? 1 : 0).append(System.lineSeparator());
            }
            count--;
            
        }
        scan.close();
        System.out.println(sb.toString());
    }
	
	private static void saveTrack(int before, int after){
		Integer beforeTrack = trackMap.get(before);
		if (beforeTrack != null) {
			if (beforeTrack == 1) {
				trackMap.remove(before);
			} else {
				trackMap.put(before, beforeTrack - 1);
			}
		}
        
		Integer afterTrack = trackMap.get(after);
		if (afterTrack == null) {
			trackMap.put(after, 1);
		} else if (afterTrack != null) {
			trackMap.put(after, afterTrack + 1);
		}
	}

    public static int check(int val){
    	Integer cnt = map.get(val);
    	if(cnt == null) return 0;
    	else return cnt;
    }
}
