package implementation;

import java.io.IOException;
import java.util.Scanner;

public class HalloweenSale {

	// Complete the howManyGames function below.
	static int howManyGames(int first, int diff, int min, int budget) {
		int cnt = 0, cur = first;
		while(budget >= cur){
			budget -= cur;
			cnt++;
			if(cur > min) {
				cur -= diff;
				if(cur < min) cur = min;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		String[] pdms = scanner.nextLine().split(" ");

		int p = Integer.parseInt(pdms[0]);
		int d = Integer.parseInt(pdms[1]);
		int m = Integer.parseInt(pdms[2]);
		int s = Integer.parseInt(pdms[3]);

		int answer = howManyGames(p, d, m, s);

		System.out.println(answer);

		scanner.close();
	}
}
