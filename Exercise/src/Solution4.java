import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		s.nextInt();
		
		int k = s.nextInt();
		String str = s.next();
		
		if(k>=str.length()){
			for(int i=0;i<str.length();i++){
				System.out.print('9');
			}
			System.out.println();
			return;
		}
		
		if(str.length()==1){
			if(k == 1){
				System.out.println("9");
				return;
			}else{
				System.out.println(str);
			}
		}
		char[] chs = str.toCharArray();
		int half = chs.length/2;
		
		char[] front = Arrays.copyOfRange(chs, 0, half);
		int start = chs.length%2==0?half:(half)+1;
		String middle = str.length()%2==0?"":"" + str.charAt(str.length()/2);
		char[] end = Arrays.copyOfRange(chs, start, chs.length);
		
		ArrayList changePoint = new ArrayList();
		ArrayList check9 = new ArrayList();
		int[] test = new int[3];
		for(int i=0;i<front.length;i++){
			if(front[i]!=end[front.length-i-1]) {
				changePoint.add(i);

				if(front[i] != '9' && end[front.length-i-1] != '9') {
					check9.add(3);
					test[2]++;
				}
				else if(front[i] == '9' && end[front.length-i-1] != '9') {
					test[0]++;
					check9.add(1);
				}
				else {
					test[1]++;
					check9.add(2);
				}
			}
		}
		
		if(changePoint.size()>k) {
			System.out.println(-1);
			return;
		}
		
		if(k==1 && chs.length % 2 == 1 && changePoint.size()==0){
			System.out.println(new String(front) + "9" + new String(end));
			return;
		}
		
		int idx = 0;
		for(int i=0;i<front.length;i++){
			if(front[i]!='9' && k - 2 >= changePoint.size() - idx){
				front[i] = end[front.length-i-1] = '9';
				k-=2;
				if(changePoint.size() > idx && (int)changePoint.get(idx) == i){
					idx++;
				}
			}
			if(changePoint.size() > idx && (int)changePoint.get(idx) == i){
				int c9 = (int)check9.get(idx);
				if(c9 == 2){
					front[(int)changePoint.get(idx)] = '9';
				}else if(c9 == 1){
					end[front.length-(int)changePoint.get(idx)-1] = '9';
				}else{
					if(k - 2 >= changePoint.size() - idx - 1){
						front[(int)changePoint.get(idx)] = end[front.length-(int)changePoint.get(idx)-1] = '9';
						k--;
					}else{
						char aa = front[(int)changePoint.get(idx)];
						char bb = end[front.length-(int)changePoint.get(idx)-1];
						int a = new String("" + aa).charAt(0);
						int b = new String("" + bb).charAt(0);
						front[(int)changePoint.get(idx)] = end[front.length-(int)changePoint.get(idx)-1] = (char)(Integer.max(a,  b));
					}
				}
				idx++;
				k--;
			}
		}
		
		if(k>=2){
			for(int i=0;i<front.length;i++){
				if(k<2) break;
				else if(front[i] != '9'){
					front[i] = end[front.length-i-1] = '9';
					k-=2;
				}
			}
		}
		
		if(k==1 && !"".equals(middle)){
			middle = "9";
		}
		
		showResult(front, middle, end);
		s.close();
	}

	private static void showResult(char[] front, String middle, char[] end) {
		StringBuffer sf = new StringBuffer();
		String output = sf.append(new String(front)).append(middle).append(new String(end)).toString();
		System.out.println(output);
		test(output);
	}

	private static void test(String output) {
		char[] a = output.toCharArray();
		for(int i=0;i<a.length;i++){
			if(a[i]!='9'){
//				System.out.println(i);
			}
		}
		
	}
}