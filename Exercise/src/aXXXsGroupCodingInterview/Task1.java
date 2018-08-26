package aXXXsGroupCodingInterview;

public class Task1 {

	public static void main(String[] args) {
		Task1 t = new Task1();
		int[] arr = {1, 4, -1, 3, 2};
		
		System.out.println(t.solution(arr));

	}

	int solution(int[] A) {
		if(A.length == 0) return 0;
		else{
			int length = 1, index = 0;
			while(A[index]!=-1){
				length++;
				index = A[index];
			}
			return length;
		}
	}
}