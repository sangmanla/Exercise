package datastructure.linkedList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 * @author sam
 *
 */
public class ReverseaDoublyLinkedList {

	static class DoublyLinkedListNode {
		public int data;
		public DoublyLinkedListNode next;
		public DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
			this.prev = null;
		}
	}

	static class DoublyLinkedList {
		public DoublyLinkedListNode head;
		public DoublyLinkedListNode tail;

		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
				node.prev = this.tail;
			}

			this.tail = node;
		}
	}

	public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			System.out.print(node.data);

			node = node.next;

			if (node != null) {
				System.out.print(sep);
			}
		}
	}

	// Complete the reverse function below.

	/*
	 * For your reference:
	 *
	 * DoublyLinkedListNode { int data; DoublyLinkedListNode next;
	 * DoublyLinkedListNode prev; }
	 *
	 */
	static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
		DoublyLinkedListNode tmp = null, prev = null;
		while(head!=null){
			tmp = head.next;
			head.next = head.prev;
			head.prev = tmp;
			prev = head;
			head = head.prev;
		}
		return prev;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			DoublyLinkedList llist = new DoublyLinkedList();

			int llistCount = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount; i++) {
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist.insertNode(llistItem);
			}

			DoublyLinkedListNode llist1 = reverse(llist.head);

			printDoublyLinkedList(llist1, " ", null);
			System.out.println();
		}

		scanner.close();
	}
}
