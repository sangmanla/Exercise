package datastructure.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class TopView {

	/*
	 * class Node int data; Node left; Node right;
	 */
	public static void topView(Node root) {
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		class My{
			public Node node;
			public int position;
			public My(Node node, int position){
				this.node = node;
				this.position = position;
			}
		};
		
		Queue<My> queue = new LinkedList<My>();
		queue.add(new My(root, 0));
		
		while(!queue.isEmpty()){
			My cur = queue.poll();
			if(!map.containsKey(cur.position)){
				map.put(cur.position, cur.node);
			}
			
			if(cur.node.left!=null) queue.add(new My(cur.node.left, cur.position - 1));
			if(cur.node.right!=null) queue.add(new My(cur.node.right, cur.position + 1));
		}
		
		map.entrySet().stream().sorted((x, y) -> x.getKey() > y.getKey() ? 1 : -1).forEach(entry -> {
			System.out.print(entry.getValue().data + " ");
		});
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
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
		topView(root);
	}
}