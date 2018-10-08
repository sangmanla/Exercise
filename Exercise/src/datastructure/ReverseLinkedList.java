package datastructure;

import java.util.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        char[] array = "I am a test string.".toCharArray();
        for(char c : array){
            list.add(c);
        }
        
        int idx = 7;
        
        for(int i=0;i<idx/2;i++){
            int lIdx = idx - i - 1;
            char temp = list.get(lIdx);
            list.set(lIdx, list.get(i));
            list.set(i, temp);
        }
        list.stream().forEach(System.out::print);
    }
}
