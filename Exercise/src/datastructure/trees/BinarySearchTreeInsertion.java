package datastructure.trees;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * 
 * @author sam
 *
 */
public class BinarySearchTreeInsertion {
	public static void preOrder(Node root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

	/*
	 * Node is defined as : class Node int data; Node left; Node right;
	 * 
	 */

	public static Node insert(Node root, int data) {
		boolean inserted = false;
		Node curNode = root;
		while(!inserted){
			if(curNode!=null){
				if(data < curNode.data) {
					if(curNode.left!=null){
						curNode = curNode.left;
					}else{
						curNode.left = new Node(data);
						inserted = true;
					}
				}else if(data > curNode.data){
					if(curNode.right!=null){
						curNode = curNode.right;
					}else{
						curNode.right = new Node(data);
						inserted = true;
					}
				}
			}else{
				root = new Node(data);
				inserted = true;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		preOrder(root);
	}
}

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}