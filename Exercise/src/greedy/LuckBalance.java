package greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/luck-balance/problem
 * @author sam
 *
 */
public class LuckBalance {

	// Complete the luckBalance function below.
    static int luckBalance(int n, int k, int[][] contests) {
    	ArrayList<int[]> list = new ArrayList<int[]>();
    	int maxLuck = 0;
    	
    	for(int[] contest : contests){
    		if(contest[1] == 0) maxLuck+= contest[0];
    		else{
    			list.add(contest);
    		}
    	}
    	
    	list = (ArrayList<int[]>)list.stream().sorted(Comparator.comparing(val->val[0], Comparator.reverseOrder())).collect(Collectors.toList());

    	int index = k;
    	for(int[] arr : list){
    		index--;
    		if(index>=0){
    			maxLuck += arr[0];
    		}else{
    			maxLuck -= arr[0];
    		}
    	}
    	
    	return maxLuck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        System.out.println(luckBalance(n, k, contests));;
        scanner.close();
    }
}
