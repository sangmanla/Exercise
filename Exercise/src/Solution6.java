import java.util.Scanner;

public class Solution6 {

    static long candies(int n, int[] arr) {
    	long result = 0;
    	long[] cnt = new long[arr.length];
    	
    	for(int i=0;i<arr.length;i++){
    		cnt[i] = 1;
    		if(i!=0 && arr[i] > arr[i-1]) cnt[i] = cnt[i-1] + 1;
    	}
    	
    	for(int i=arr.length-2;i>=0;i--){
    		if(arr[i] > arr[i+1] && cnt[i] <= cnt[i+1]) cnt[i] = cnt[i+1] + 1;
    	}
    	
//    	print(cnt);
    	return get(cnt);
    }
    
    private static long get(long[] cnt) {
    	long r = 0;
    	for(long a : cnt) r+= a; 
		return r;
	}

	static void print(int[] arr){
    	for(int a : arr) System.out.print(a + ",");
    	System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
//        int n = 100000;
//        int[] arr = new int[n];
        for(int i=n;i>0;i--) arr[i-1] = i;
        
//        for(int arr_i = 0; arr_i < n; arr_i++){
//            arr[arr_i] = in.nextInt();
//        }
        
        long result = candies(n, arr);
        System.out.println(result);
        in.close();
    }
}
