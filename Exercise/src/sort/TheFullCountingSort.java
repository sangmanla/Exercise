package sort;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/countingsort4/problem
 * @author sam
 *
 */
public class TheFullCountingSort {
	static int xMax = 100;
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        StringBuffer[] list = new StringBuffer[xMax];
        for(int i=0;i<100;i++) list[i] = new StringBuffer();
        
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            String s = in.next();
            
            if(a0 < n / 2) s = "-";
            
            list[x].append(s + " ");
        }
        
        for(StringBuffer sb : list){
        	System.out.print(sb.toString());
        }
        
        in.close();
    }
}
