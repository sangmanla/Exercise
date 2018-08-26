package implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/3d-surface-area/problem
 * @author sam
 */
public class Surface3DArea {
	static int height = 0, width = 0, maxZ = 0;;
	
	public static void main(String[] args) {
		int[][][] arr = getArray();
		int result = 0;
		for(int h=0;h<height;h++){
			for(int w=0;w<width;w++){
				for(int z=0;z<maxZ;z++){
					if(arr[h][w][z]==0) continue;
					result+=6;
					if(w-1>=0 && arr[h][w-1][z]==1) result--;
					if(w+1<width && arr[h][w+1][z]==1) result--;
					if(h-1>=0 && arr[h-1][w][z]==1) result--;
					if(h+1<height && arr[h+1][w][z]==1) result--;
					if(z-1>=0 && arr[h][w][z-1]==1) result--;
					if(z+1<maxZ && arr[h][w][z+1]==1) result--;
				}
			}
		}
		
		System.out.println(result);
	}

	private static int[][][] getArray() {
		Scanner scan = new Scanner(System.in);
		height = scan.nextInt();
		width = scan.nextInt();
		scan.nextLine();
		
		int[][] hw = new int[height][width];
		for(int h=0;h<height;h++){
			int[] nums = makeNums(scan.nextLine());
			for(int w=0;w<nums.length;w++){
				hw[h][w] = nums[w];
				maxZ = Integer.max(maxZ, nums[w]);
			}
		}

		int[][][] arr = new int[height][width][maxZ];
		for(int h=0;h<height;h++){
			for(int w=0;w<width;w++){
				for(int n=0;n<maxZ;n++){
					arr[h][w][n] = (n<hw[h][w]?1:0);
				}
			}
		}
		scan.close();
		return arr;
	}

	private static int[] makeNums(String line) {
		String[] nums = line.split(" ");
		int[] iNums = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			iNums[i] = Integer.parseInt(nums[i]);
		}
		return iNums;
	}
}