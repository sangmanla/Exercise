package sort;
/**
 * 버블 소트는 N제곱의 성능으로 실제로는 쓰이지 않고, 학습용도로만 쓰임
 * 알고리즘이 간단.
 * @author sam
 *
 */
public class BubbleSort {
	
	public static void main(String[] args) {
		char n[] = "108923174140281234567890".toCharArray();
		System.out.println(n.length);
		System.out.println(n);
		int lastSwap, end = n.length-1;
		int count = 0;
		while(end > 0){
			lastSwap = 0;
			
			for(int i=0;i<end;i++){
				count++;
				if(n[i] > n[i+1]){
					char t = n[i];
					n[i] = n[i+1];
					n[i+1] = t;
					lastSwap = i;
				}
			}
			
			end = lastSwap;
		}
		System.out.println("count : " + count);
		System.out.println(n);
	}
}