package west;

public class First10Fibonacci {

    public static void main(String[] args) {
//	int result = getSumOfFibonacci(0, 1, 0, 0);
	
	int result = getValue();
	System.out.println(result);
    }

    private static int getValue() {
	int result = 0;
	int prev=0, next=1;
	for(int i=0;i<10;i++){
	    int temp = next;
	    next = prev + next;
	    prev = temp;
	    result += next;
	    System.out.println(next);
	}
	return result;
    }

    private static int getSumOfFibonacci(int prev, int next, int depth, int sum) {
	depth++;
	if(depth>10) return sum;
	else {
	    int newFib = prev+next;
	    System.out.println(newFib);
	    sum += newFib;
	    return getSumOfFibonacci(next, prev+next, depth, sum);
	}
    }
}