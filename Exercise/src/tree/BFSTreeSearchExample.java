package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTreeSearchExample {
	public static void main(String[] args) {
		int[] nums = {10,5,8,15,11,17,2,4,7,9};
		Node root = null;
		for(int num : nums) {
			root = addNode(root, num); 
		}
		
//		String type = "root";
//		printTree(root, 1, type, -1);
		System.out.println("[" + searchTree(root) + "]");
	}
	
//	public static void printTree(Node root, int lvl, String type, int pData){
//		System.out.println(lvl + " : " + root.data + " | " + type + " | " + pData);
//		if(root.left!=null) printTree(root.left, lvl+1, "left", root.data);
//		if(root.right!=null) printTree(root.right, lvl+1, "right", root.data);
//	}
	
	public static String searchTree(Node root){
		Queue<Node> q = new LinkedList<Node>();
		String resultTxt = "";
		q.offer(root);
		
		while(!q.isEmpty()){
			Node node = q.poll();
			if(node.left!=null) q.offer(node.left);
			if(node.right!=null) q.offer(node.right);
			resultTxt += node.data + " ";
		}
		return resultTxt;
	}
	
	public static Node addNode(Node root, int data){
		if(root == null) {
			return new Node(data);
		}else{
			Node cur;
			if(root.data >= data) {
				cur = addNode(root.left, data);
				root.left = cur;
			}else {
				cur = addNode(root.right, data);
				root.right = cur;
			}
			
			return root;
		}
	}
}

class Node{
	Node left,right;
	int data;
	public Node(int d){
		this.data = d;
		right = left = null;
	}
}
