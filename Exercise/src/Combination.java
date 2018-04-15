import java.util.ArrayList;

public class Combination {
	public static void main(String[] args) {
		int[] arr = new int[4];
		combination(arr, 0, 50, 4, 0);
	}

	static int gIndex = 1;
	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0){
			String a = "";
			for(int i=0;i<arr.length;i++){
				a += arr[i] + ",";
			}
			System.out.println(gIndex + " : " + a);
			gIndex++;
		}
		else if (target == n)
			return;
		else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}
}