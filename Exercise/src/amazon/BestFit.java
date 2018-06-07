package amazon;

import java.util.Arrays;

public class BestFit {

	public static void main(String[] args) {
		int[] blockSize = {100, 500, 200, 300, 600};
		int[] processSize = {212, 417, 112, 426};
		int[] allocation = new int[processSize.length];
		
		for(int i=0;i<processSize.length;i++){
			int choosen = Integer.MAX_VALUE;
			for(int j=0;j<blockSize.length;j++){
				if(blockSize[j] >= processSize[i] && blockSize[j] < choosen) {
					choosen = blockSize[j];
					allocation[i] = j;
				}
			}
			if(allocation[i]!=0) {
				blockSize[allocation[i]] -= processSize[i];
			}
		}
		
		System.out.println("Process No.\tProcess Size\tBlock No.");
		
		for(int i=0;i<processSize.length;i++){
			System.out.println((i+1) + "\t" + processSize[i] + "\t" + (allocation[i]+1));
		}
	}
}