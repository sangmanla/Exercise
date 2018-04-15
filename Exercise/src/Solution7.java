import java.math.BigInteger;
import java.util.Scanner;

public class Solution7 {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		String[] string_array = string.split("");
		long _mod = (long) Math.pow(10, 9) + 7;
		long prev_iter_sum = Long.parseLong(string_array[0]);
		long prev_iter_total_sum = prev_iter_sum;
		for(int i=1;i<string_array.length;i++) {
			String c = string_array[i];
			long c_long = Long.parseLong(c);
			long my_sum = (prev_iter_sum*10 + c_long*(i+1)) % _mod;
			long my_total_sum = (prev_iter_total_sum + my_sum) % _mod;

			prev_iter_sum = my_sum;
			prev_iter_total_sum = my_total_sum;
		}
		System.out.println(prev_iter_total_sum);
		scanner.close();
    }
}