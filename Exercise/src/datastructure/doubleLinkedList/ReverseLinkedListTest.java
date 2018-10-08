package datastructure.doubleLinkedList;

import java.util.LinkedList;
import java.util.stream.IntStream;

/*
 * O(n)
 */
public class ReverseLinkedListTest{
    public static void main(String[] args) throws InterruptedException {
	LinkedList<Integer> list = new LinkedList<Integer>();
	IntStream.range(0, 100).forEach(x -> list.add(x));
	list.stream().forEach(x -> System.out.print(x + ","));
	System.out.println();
	for(int i=0;i<list.size()/2;i++){
	    int temp = list.get(i);
	    list.set(i, list.get(list.size()-i-1));
	    list.set(list.size()-i-1, temp);
	}
	list.stream().forEach(x -> System.out.print(x + ","));
    }
}