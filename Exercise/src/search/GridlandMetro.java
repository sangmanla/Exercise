package search;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/gridland-metro/problem
 * @author sam
 *
 */
public class GridlandMetro {
	static BigInteger gridlandMetro(int n, int m, int k, int[][] track) {
		for(int i=0;i<track.length;i++){
			for(int j=i+1;j<track.length;j++){
				if(track[j][0] < track[i][0]){
					swap(track, i, j);
				}else if(track[j][0] == track[i][0] && track[j][1] < track[i][1]){
					swap(track, i, j);
				}
			}
		}
		
		BigInteger result = BigInteger.valueOf(n).multiply(BigInteger.valueOf(m));
		
		Scope scope = null;
		for(int i=0;i<track.length;i++){
			if(i==0){
				scope = new Scope(track[i]);
			}else{
				if(scope.isSameRow(track[i])){
					scope.addRange(track[i]);
				}else{
					result = result.subtract(BigInteger.valueOf(scope.getTracks()));
					scope = new Scope(track[i]);
					scope.addRange(track[i]);
				}
			}
		}
		if(scope!=null) result = result.subtract(BigInteger.valueOf(scope.getTracks()));
        return result;
    }
	
	public static class Scope {
		public ArrayList<int[]> ranges;
		public int rowNum = 0;
		
		public Scope(int[] track){
			if(ranges == null) ranges = new ArrayList<>();
			rowNum = track[0];
			addRange(track);
		}
		
		public int getTracks() {
			int result = 0;
			for(int[] range : ranges){
				result += range[1] - range[0] + 1;
			}
			return result;
		}

		public boolean isSameRow(int[] is) {
			return rowNum == is[0];
		}

		public Scope(int row){
			rowNum = row;
		}
		
		public int n = 0, m = 0;
		
		public void addRange(int[] range){
			addRange(range[1], range[2]);
		}

		public void addRange(int a, int b) {
			if(ranges == null) {
				ranges = new ArrayList<>();
				int[] newRange = {a, b};
				ranges.add(newRange);
			}else{
				boolean isAdded = false;
				for(int i=0;i<ranges.size();i++){
					int[] cur = ranges.get(i);
					if(cur[1] < a) continue;
					else if(isRange(cur, a) || isRange(cur, b)){
						int start = i;
						while(i<ranges.size() && (ranges.get(i)[0] <= a || ranges.get(i)[0] <= b)){
							i++;
						}
						int[] newRange = {ranges.get(start)[0], Integer.max(b, ranges.get(i-1)[1])};
						for(int k=start;k<i;k++){
							ranges.remove(start);
						}
						isAdded = true;
						ranges.add(start, newRange);
						break;
					}
				}
				if(!isAdded) {
					int[] newRange = {a, b};
					ranges.add(newRange);
				}
			}
		}
		
		private boolean isRange(int[] range, int x){
			return isRange(range[0], range[1], x);
		}
		
		private boolean isRange(int low, int high, int x) {
			return x >= low && x <= high;
		}
	}

	private static void swap(int[][] track, int i, int j) {
		int[] temp = track[j];
		track[j] = track[i];
		track[i] = temp;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] track = new int[k][3];
        for(int track_i = 0; track_i < k; track_i++){
            for(int track_j = 0; track_j < 3; track_j++){
                track[track_i][track_j] = in.nextInt();
            }
        }
        BigInteger result = gridlandMetro(n, m, k, track);
        System.out.println(result.toString());
        in.close();
    }
}
