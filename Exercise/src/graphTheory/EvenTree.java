package graphTheory;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/even-tree/problem#!
 * 
 * @author sam
 *
 */
public class EvenTree {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] init = scan.nextLine().split(" ");
		int numCount = Integer.parseInt(init[0]);
		int lineNum = Integer.parseInt(init[1]);

		MyTree tree = new MyTree(1);

		for (int i = 0; i < lineNum; i++) {
			String[] nums = scan.nextLine().split(" ");
			int num1 = Integer.parseInt(nums[0]);
			int num2 = Integer.parseInt(nums[1]);
			tree.addEdge(num1, num2, numCount);
		}
		
		MyTree.setCnt(tree);
//		tree.printCnt();
		System.out.println((tree.getEvenCnt()-1));
		scan.close();
	}
}

class MyTree {
	public MyTree(int initNum) {
		cur = initNum;
	}

	public MyTree(MyTree p, int num, int numCount) {
		cur = num;
		parent = p;
	}

	public int numCount = 0;
	public Integer cur = null;
	public MyTree parent = null;
	public int cnt = 0;
	public ArrayList<MyTree> children = new ArrayList<>();

	public void addEdge(int a, int b, int numCount) {
		if (cur == b) {
			children.add(new MyTree(this, a, numCount));
		} else {
			children.forEach(tree -> {
				tree.addEdge(a, b, numCount);
			});
		}
	}

	public static int setCnt(MyTree tree) {
		int sum = 1;

		if (tree.children.size() > 0) {
			for (int i = 0; i < tree.children.size(); i++) {
				sum += setCnt(tree.children.get(i));
			}

		}
		tree.cnt = sum;
		return sum;
	}
	
	public void printCnt(){
		System.out.println(cur + " | " + cnt);
		children.forEach(tree -> {
			tree.printCnt();
		});
	}
	
	public int getEvenCnt(){
		int result = 0;
		if(cnt != numCount && cnt % 2 == 0) {
			result = 1;
//			System.out.println("when even : " +  cnt);
		}
		
		for(MyTree tree : children){
			result += tree.getEvenCnt();
		}
		return result;
	}
}