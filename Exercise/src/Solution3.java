import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution3 {
	public static int maxScore = Integer.MIN_VALUE;
	public static int m = 0, n = 0;
	public static int max = Integer.MAX_VALUE;
	public static int[][] arr;
	public static ArrayList<ArrayList<Range>> list = new ArrayList<>();
	public static boolean[][] accessable;
	public static boolean verbose = true;

	public static void main(String[] args) throws Exception {
		setMatrix();
		for (int i = 0; i < m; i++) list.add(getRanges(accessable[i], arr[i]));

		calculateScore();

		if (verbose) printAccessable();
		System.out.println(maxScore);
	}

	private static void printAccessable() {
		for(ArrayList<Range> rgs : list){
			for(Range rg : rgs){
				System.out.print(rg + "\t");
			}
			System.out.println();
		}
		for (boolean[] bb : accessable) {
			for (boolean b : bb) {
				System.out.print(b + "\t");
			}
			System.out.println();
		}
		System.out.println("called : " + called);
	}

	static int called = 0;
	public static boolean find = false;
	/**
	 *  accessible은 minus와 plus로 구분한다.
	 * 체크 시 상단에서 하단으로 내려가는 방법을 쓰지 말고...
	 * 각 row의 index들을 0-0-0-0 으로 설정하고 값을 계산해본다. while문 이용.
	 * 다음에 index를 하나 이동해 보는데, 이때 이동할 row는 다음 값으로 이동했을때 
	 * 얻게되는 순수 이익을 먼저 계산해본다. 즉 Range의 Sum을 먼저 계산해보고
	 * 가능 여부를 판단.. sum이 이전 값보다 커보이면 일단 순회를 해본다.
	 * 순회하다가 값이 최대 이익보다 작아지면 그점이 최대값이다.  (무조건 커져야됨 ) - 그래야 멈출수있음
	 * 
	 * Range의 Sum이 
	 * @param pList
	 * @param pRange
	 * @param line
	 * @param score
	 */
	private static void calculateScore() {
		int[] pos = new int[m];
		boolean findMax = false;
		boolean isFirst = true;
		while(!findMax){
			int sum = maximize(pos, 0);
			
			if(isFirst){
				isFirst = false;
				maxScore = sum;
			}else{
				if(maxScore <= sum) {
					maxScore = sum;
					findMax = true;
				}
			}
			pos = getNextPos(pos);
		}
	}
	
	private static void seePos(int[] pos){
		for(int i : pos){
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	private static int[] getNextPos(int[] pos) {
		int minDiff = Integer.MAX_VALUE, lineNum = -1;
		
		for(int i=0;i<pos.length;i++){
			if(pos[i] == list.get(i).size()-1) continue;
			else{
				int diff = list.get(i).get(pos[i]).sum - list.get(i).get(pos[i+1]).sum;
				if(diff <= minDiff){
					minDiff = diff;
					lineNum = i;
				}
			}
		}
		pos[lineNum]++;
		seePos(pos);
		return pos;
	}

	private static int maximize(int[] pos, int sum) {
		for(int i=0;i<m;i++) {
			int var = 0;
			
			var = list.get(i).get(pos[i]).sum;
			if(i!=0 && !list.get(i).get(pos[i]).checkRange(list.get(i-1).get(pos[i-1]))){
				var = list.get(i-1).get(pos[i-1]).getDistance(list.get(i).get(pos[i]), arr, i-1);
			}
			
			sum += var;
		}
		return sum;
	}

	private static ArrayList<Range> getRanges(boolean[] accessable, int[] arr) {
		ArrayList<Range> list = new ArrayList<>();
		int start = max;
		
		for(int i=0;i<n;i++){
			if(accessable[i] && start==max) start = i;
			else if(!accessable[i] && start != max){
				addRegionalRange(arr, list, start, i - 1);
				start = max;
			}
		}
		if(accessable[n-1]){
			addRegionalRange(arr, list, start, n - 1);
		}
		
		Collections.sort(list, Collections.reverseOrder());
		return list;
	}

	private static void addRegionalRange(int[] arr, ArrayList<Range> list, int start, int dest) {
		for (int i = start; i <= dest; i++) {
			for (int k = i; k <= dest; k++) {
				list.add(new Range(i, k, arr));
			}
		}
	}

	private static void setMatrix() {
		Scanner s = new Scanner(System.in);
		m = s.nextInt();
		n = s.nextInt();
		arr = new int[m][n];
		accessable = new boolean[m][n];
		double sum = 0;
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				int val = s.nextInt();
				arr[row][col] = val;
				sum += val;
			}
		}
		int avg = (int)Math.floor(sum/(m*n));
		for(int row =0;row<m;row++){
			for (int col = 0; col < n; col++) {
				int cur = arr[row][col];
				if (cur + up(row, col) >= avg || cur + left(row, col) >= avg || cur + right(row, col) >= avg) {
					accessable[row][col] = true;
				}
			}
		}
		s.close();
	}

	private static int right(int x, int y) {
		return gv(x, y + 1);
	}

	private static int left(int x, int y) {
		return gv(x, y - 1);
	}

	private static int up(int x, int y) {
		return gv(x - 1, y);
	}

	public static int gv(int x, int y) {
		if (m <= x || x < 0)
			return -251;
		else if (n <= y || y < 0)
			return -251;
		else
			return arr[x][y];
	}
}