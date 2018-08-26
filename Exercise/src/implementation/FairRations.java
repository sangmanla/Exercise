package implementation;

import java.io.IOException;
import java.util.Scanner;


/**
 * https://www.hackerrank.com/challenges/fair-rations/problem
 * @author sam
 *
 */
public class FairRations {

    static int fairRations(int[] B) {
    	int result = 0;
    	int sum = 0;
    	for(int a : B){
    		sum += a;
    	}
    	if(sum % 2 != 0) return -1;
    	else{
    		int pos = hasOdd(B);
    		while(pos!=-1){
    			B[pos]+=1;
    			B[pos+1]+=1;
    			result += 2;
    			pos = hasOdd(B);
    		}
    	}
    	return result;
    }
    
    static int hasOdd(int[] b){
    	int pos = -1;
    	for(int i=0;i<b.length;i++){
    		if(b[i]%2==1) {
    			return i;
    		}
    	}
    	return pos;
    }


    public static void main(String[] args) throws IOException {
    	Scanner scanner = new Scanner(System.in);
        
    	int N = Integer.parseInt(scanner.nextLine());
    	int[] B = new int[N];
        String[] BItems = scanner.nextLine().split(" ");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);
        System.out.println(result==-1?"NO":result);
        scanner.close();
    }
}
