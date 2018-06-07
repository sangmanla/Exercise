package greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/marcs-cakewalk/problem
 * @author sam
 *
 */
public class MarcsCakewalk {

	// Complete the marcsCakewalk function below.
    static long marcsCakewalk(int[] calorie) {
    	long result = 0;
    	Arrays.sort(calorie);
    	
    	for(int i=0;i<calorie.length;i++){
    		result += (calorie[calorie.length - i - 1]) * Math.pow(2, i);
    	}
    	
    	return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(scanner.nextLine());

        int[] calorie = new int[n];

        String[] calorieItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int calorieItem = Integer.parseInt(calorieItems[i]);
            calorie[i] = calorieItem;
        }

        System.out.println(marcsCakewalk(calorie));

        scanner.close();
    }

}
