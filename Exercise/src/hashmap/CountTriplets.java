package hashmap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps&h_r=next-challenge&h_v=zen
 * @author sam
 *
 */
public class CountTriplets {

	// Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        if (r == 1) {
        	Map<Long, Long> map = new HashMap<Long, Long>();
        	arr.stream().forEach(num ->{
        		if(map.containsKey(num)){
        			map.put(num, map.get(num)+1);
        		}else{
        			map.put(num, 1L);
        		}
        	});
        	long result = 0;
        	Iterator it = map.entrySet().iterator();
        	
        	while(it.hasNext()){
        		long value = (long)((Entry)it.next()).getValue();
        		if(value >= 3){
        			result += value * (value-1) * (value-2);
        		}
        	}
            return result;
        }

        long cnt = 0;
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        arr.stream().forEach(x -> {
            map.put((double) x, (map.containsKey((double) x) ? map.get((double) x) + 1 : 1));
        });

        int x = 0;
        while (true) {
            try {
                if (map.containsKey(Math.pow(r, x))) {
                	cnt += map.get(Math.pow(r, x)) * map.get(Math.pow(r, x + 1)) * map.get(Math.pow(r, x + 2));
                }
                x++;
            } catch (Exception e) {
                break;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        long com = scan.nextLong();
        List<Long> list = new ArrayList<Long>();
        while(len-->0){
        	list.add(scan.nextLong());
        }
        System.out.println(countTriplets(list, com));
        scan.close();
    }
}
