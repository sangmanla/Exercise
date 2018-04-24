package string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CountString {
	
	long modulo = 1000000007;

	/*
	 * Complete the countStrings function below.
	 */
	static int countStrings(String r, int l) {
		int result = 0;
		ArrayList<String> list = getToken(r);
		
		list.stream().forEach(System.out::println);
		return result;
	}

	private static ArrayList<String> getToken(String r) {
		ArrayList<String> list = new ArrayList<>();
		String[] first = r.split("\\(");
		
		for(String s : first){
			list.addAll(Arrays.asList(s.split("\\)")));
		}
		return list;
	}


	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int t = Integer.parseInt(scanner.nextLine().trim());

		for (int tItr = 0; tItr < t; tItr++) {
			String[] rl = scanner.nextLine().split(" ");

			String r = rl[0];

			int l = Integer.parseInt(rl[1].trim());

			int result = countStrings(r, l);

//			System.out.println(result);
		}

		scanner.close();
	}
}
