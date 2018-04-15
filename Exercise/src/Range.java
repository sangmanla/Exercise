public class Range implements Comparable<Range> {
	public int first = 0, last = 0, sum = 0;

	Range(int a, int b) {
		first = a;
		last = b;
	}
	
	Range(int a, int b, int c) {
		first = a;
		last = b;
		sum = c;
	}

	Range(int a, int b, int[] arr) {
		first = a;
		last = b;
		for (int i = a; i <= b; i++) {
			sum += arr[i];
		}
	}

	public boolean checkRange(Range o) {
		if (o.first <= last && o.first >= first)
			return true;
		if (o.last <= first && o.last >= first)
			return true;
		return false;
	}
	
	public int getDistance(Range child, int[][] arr, int line){
		int distance = 0;
		
		int start = 0, end = 0;
		if(last < child.first){ // right
			start = last;
			end = child.first;
		}else{ // left
			start = first;
			end = child.last;
		}
		for(int i=start;i<end;i++){ // when change line
			int localDistance = 0, curLine = line - 1;
			for(int k=start;k<end;k++){ // 
				if(k == i) {
					localDistance += arr[curLine][k];
					curLine++;
				}

				if(curLine < arr.length) localDistance += arr[curLine][k];
			}
			if(distance > localDistance) distance = localDistance;
		}
		return distance;
	}

	@Override
	public int compareTo(Range o) {
		if (this.sum == o.sum)
			return 0;
		else
			return this.sum > o.sum ? 1 : -1;
	}

	@Override
	public String toString() {
		return first + "~" + last + "=" + sum;
	}
}