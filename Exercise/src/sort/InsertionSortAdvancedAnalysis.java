package sort;

import java.util.Scanner;

public class InsertionSortAdvancedAnalysis {
    static int insertionSort(int[] arr) {
        int cnt = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i] < arr[0]){
                int tmp = arr[i];
                for(int k=i;k>0;k--){
                	arr[k] = arr[k-1];
                    cnt++;
                }
                arr[0] = tmp;
            }else if(arr[i] > arr[i-1]){
                // do nothing
            }else{
                for(int j=i-1;j>=0;j--){
                    if(arr[j] > arr[j+1]){
//                        int t = arr[j+1];
//                        arr[j+1] = arr[j];
//                        arr[j] = t;
                        cnt++;
                    }else{
                        break;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = insertionSort(arr);
            System.out.println(result);
        }
        in.close();
    }
}
