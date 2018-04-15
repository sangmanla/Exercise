import java.util.ArrayList;
import java.util.Scanner;

public class AhoCorasickAlgo {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		in.nextLine();
		String[] genes = getGenes(in, n);

		int[] health = getHealth(in, n);
		int s = in.nextInt();

		AhoCorasick ac = buildStructure(genes, health);

		long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
		for (int a0 = 0; a0 < s; a0++) {
			int start = in.nextInt();
			int end = in.nextInt();
			String find = in.next();
			long val = getValue(ac, find, start, end);
			if (val > max)
				max = val;
			if (val < min)
				min = val;
		}

		System.out.println(min + " " + max);
	}

	private static String[] getGenes(Scanner in, int n) {
		String[] genes = new String[n];
		for (int genes_i = 0; genes_i < n; genes_i++) {
			genes[genes_i] = in.next();
		}
		return genes;
	}

	public static int[] getHealth(Scanner in, int n) {
		int[] health = new int[n];
		for (int health_i = 0; health_i < n; health_i++) {
			health[health_i] = in.nextInt();
		}
		return health;
	}

	public static AhoCorasick buildStructure(String[] patterns, int[] values) {
		AhoCorasick ahoCorasick = new AhoCorasick();
		int index = 0;
		for (String str : patterns)
			ahoCorasick.add(str, index, values[index++]);

		return ahoCorasick;
	}

	public static long getValue(AhoCorasick ac, String find, int start, int end) {
		Node node;
		long total = 0;
		for (int i = 0; i < find.length(); ++i) {
			node = ac.head;
			ac.isEnd = false;
			System.out.println("i ========= " + i);
			for (int j = 0; j + i < find.length(); ++j) {
				System.out.println("j : " + (i+j));
				node = ac.findNext(find.charAt(i + j), node);
				if (node == null)
					break;
				if (ac.isEnd) {
					ac.isEnd = false;
					for (int k = 0; k < ac.index.size(); k++) {
						if ((int) ac.index.get(k) >= start && (int) ac.index.get(k) <= end) {
							total += (long) ac.value.get(k);
						}
					}
				}
			}
		}

		return total;
	}
}

class AhoCorasick {
	Node head;

	public AhoCorasick() {
		this.head = new Node();
	}

	public void add(String word, int index, int value) {
		Node node = head;
		char[] chars = word.toCharArray();
		for (int i = 0; i < chars.length; ++i)
			node = node.addChild(chars[i]);

		node.setEnd();
		node.addIndex(index);
		node.addValue(value);
	}

	public boolean isEnd = false;
	public ArrayList index = new ArrayList();
	public ArrayList value = new ArrayList();

	public Node findNext(char ch, Node node) {
		if (node == null)
			return null;

		Node current = node.getChild(ch);

		if (current != null && current.isEnd) {
			index = current.index;
			value = current.value;
			isEnd = true;
		}

		return current;
	}
}

class Node {
	public char currentChar;
	public boolean isEnd = false;
	public Node children[] = new Node[26];
	public ArrayList index = new ArrayList();
	public ArrayList value = new ArrayList();

	public Node(char c) {
		currentChar = c;
	}

	public Node() {
		if (children == null)
			children = new Node[26];
	}

	public Node addChild(char c) {
		if (children[c - 'a'] == null) {
			children[c - 'a'] = new Node(c);
		}

		return children[c - 'a'];
	}

	public Node getChild(char c) {
		return children[c - 'a'];
	}

	public void addIndex(int i) {
		index.add(i);
	}

	public void addValue(long i) {
		value.add(i);
	}

	public void setEnd() {
		isEnd = true;
	}
}