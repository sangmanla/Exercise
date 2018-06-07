package amazon;

public class Pow {

	public static void main(String[] args) {
		System.out.println((int)pow(2, 31));
	}
	
	public static double pow(int a, int b){
		if(b == 0) return 1;
		else if(b == 1) return a;
		else if(b % 2 == 0) return pow(a * a, b/2);
		else return a * pow(a * a, b/2);
	}
}
