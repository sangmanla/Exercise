package datastructure.trees;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/swap-nodes-algo/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * @author sam
 *
 */
public class SwapNodesAlgo {
    static int idx = 0;
    public static void inOrder(MyNode root, int[] iList){
        if (root != null){
        	inOrder(root.left, iList);
        	System.out.print(root.data + " ");
            inOrder(root.right, iList);
        }
    }
    
	private static Map<Integer, MyNode> buildNodeMap(int[][] indexes) {
		Map<Integer, MyNode> map = new HashMap<Integer, MyNode>();
		MyNode root = new MyNode(1, 1);
		map.put(1, root);
		for (int i = 0; i < indexes.length; i++) {
			int[] values = indexes[i];
			MyNode curNode = map.get(i+1);
			if(values[0] != -1) {
				MyNode left = new MyNode(values[0], curNode.depth + 1);
				curNode.left = left;
				map.put(values[0], left);
			}
			if(values[1] != -1) {
				MyNode right = new MyNode(values[1], curNode.depth + 1);
				curNode.right = right;
				map.put(values[1], right);
			}
		}
		return map;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        Map<Integer, MyNode> map = buildNodeMap(indexes);
    	
    	int[][] result = new int[queries.length][indexes.length];
		for (int i = 0; i < queries.length; i++) {
			int query = queries[i];
			map.entrySet().parallelStream().forEach(entry -> {
				MyNode curNode = entry.getValue();
				if(curNode.depth % query == 0){
					MyNode temp = curNode.left;
					curNode.left = curNode.right;
					curNode.right = temp;
				}
			});
			
			idx = 0;
			inOrder(map.get(1), result[i]);
			System.out.println();
        }
    }
}

class MyNode {
	int data = 0;
	int depth = 0;
	MyNode left = null, right = null;
	MyNode(int init){
		this.data = init;
	}
	public MyNode(int i, int j) {
		this.data = i;
		this.depth = j;
	}
}