package search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/knightl-on-chessboard/problem
 * 
 * @author sam
 *
 */
public class KnightLOnAChessboard {

	public static int size = 0;
	public static int curMin = Integer.MAX_VALUE;
	public static int first = 0, second = 0;
	public static boolean startMinus = false;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();

		int[][] resultMatrix = new int[size][size];
		for (int i = 1; i < size; i++) {
			Points cur = new Points(0, 0, size);
			for (int k = 1; k < size; k++) {
				first = i;
				second = k;
				if (i > k) {
					continue;
				} else {
					if (startMinus) {
						resultMatrix[i][k] = -1;
					}
					if (i % 2 == 0 && k % 2 == 0 && size % 2 == 0) {
						resultMatrix[i][k] = -1;
					} else {
						curMin = Integer.MAX_VALUE;
						callRecursive(cur.getPossibleNextPos(), 0);
						resultMatrix[i][k] = curMin;
						if (i == k && resultMatrix[i][k] == -1 && size / 2 <= i) {
							startMinus = true;
						}
					}
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < size; i++) {
			for (int k = 1; k < size; k++) {
				if (i <= k) {
					int printVal = resultMatrix[i][k] == Integer.MAX_VALUE ? -1 : resultMatrix[i][k];
					sb.append(printVal).append(" ");
				} else {
					int printVal = resultMatrix[k][i] == Integer.MAX_VALUE ? -1 : resultMatrix[k][i];
					sb.append(printVal).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
		System.out.println("count : " + count);
		scan.close();
	}

	public static int count = 0;

	private static void callRecursive(List<Points> possibles, int depth) {
		count++;
		if (possibles.size() > 0) {
			depth++;
			if (curMin < depth) {
				return;
			}
			for (Points possible : possibles) {
				if (possible.x != size - 1 || possible.y != size - 1) {
					callRecursive(possible.getPossibleNextPos(), depth);
				} else {
					curMin = depth;
					break;
				}
			}
		}
	}
}

class Points {
	int x = 0;
	int y = 0;
	int size = 0;
	boolean[][] visited;

	public Points(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
		visited = new boolean[size][size];
	}

	public Points(int x, int y, int size, boolean[][] visited) {
		this.x = x;
		this.y = y;
		this.size = size;

		this.visited = new boolean[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				this.visited[i][j] = visited[i][j];
			}
		}
		this.visited[x][y] = true;
	}

	public List<Points> getPossibleNextPos() {
		List<Points> result = new ArrayList<Points>();

		int xps = x + KnightLOnAChessboard.second;
		int xms = x - KnightLOnAChessboard.second;
		int xpf = x + KnightLOnAChessboard.first;
		int xmf = x - KnightLOnAChessboard.first;
		int yps = y + KnightLOnAChessboard.second;
		int yms = y - KnightLOnAChessboard.second;
		int ypf = y + KnightLOnAChessboard.first;
		int ymf = y - KnightLOnAChessboard.first;

		checkAndAdd(result, xpf, yps, yms, xpf <= size - 1);
		checkAndAdd(result, xmf, yps, yms, xmf >= 0);
		checkAndAdd(result, xps, ypf, ymf, xps <= size - 1);
		checkAndAdd(result, xms, ypf, ymf, xms >= 0);

		return new ArrayList<>(new HashSet<>(result)).stream().sorted((i1, i2) -> {
			if (i1.x + i1.y >= i2.x + i2.y)
				return -1;
			else if (i1.x > i2.x && i1.y > i2.y)
				return -1;
			else
				return 1;
		}).collect(Collectors.toList());
	}

	private void checkAndAdd(List<Points> result, int a, int b, int c, boolean value) {
		if (value) {
			checkAndAdd2(result, a, b, c);
		}
	}

	private void checkAndAdd2(List<Points> result, int a, int b, int c) {
		if (b < size && !visited[a][b]) {
			result.add(new Points(a, b, size, visited));
		}
		if (c >= 0 && !visited[a][c]) {
			result.add(new Points(a, c, size, visited));
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this.x == ((Points) obj).x && this.y == ((Points) obj).y)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

	@Override
	public int hashCode() {
		return this.x + this.y;
	}
}