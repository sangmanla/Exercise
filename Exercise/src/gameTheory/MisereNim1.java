package gameTheory;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/misere-nim-1/problem
 * @author sam
 */
public class MisereNim1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = Integer.parseInt(scan.nextLine());
		while(cnt-- > 0){
			int num = scan.nextInt();
			int[] arr = new int[num];
			for(int i=0;i<num;i++){
				arr[i] = scan.nextInt();
			}
			
			if(num == 1){
				System.out.println(arr[0] > 1?"First":"Second");
			}else{
				int total = 0, xor = 0;
				for(int s : arr){
					total += s;
					xor ^= s;
				}
				
				if(total == num){
					System.out.println(total % 2==0?"First":"Second");
				}else{
					System.out.println(xor>0?"First":"Second");
				}
			}
		}
		scan.close();
	}
}