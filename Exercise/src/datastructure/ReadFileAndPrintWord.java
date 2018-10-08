package datastructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;

public class ReadFileAndPrintWord {
    static String path = "C:/Users/sam/Exercise/Exercise/Exercise/src/datastructure/testdata.txt";
    public static void main(String[] args) throws Exception{
	HashMap<String, Integer> map = new HashMap<>();
	BufferedReader br = new BufferedReader(new FileReader(path));
	String line = br.readLine();
	do{
	    analyze(line, map);
	}while((line = br.readLine()) != null);
	
	map.forEach((x, y) -> {
	    if(y >= 2) System.out.println(x + "(" +  y + ")");
	});
	br.close();
    }
    private static void analyze(String line, HashMap<String, Integer> map){
	String[] word = line.split(" ");
	
	Arrays.stream(word)
		.filter(x -> x!=null && !"".equals(x))
		.forEach(w->{
		    Integer val = map.get(w);
		    if(val == null) map.put(w, 1);
		    else map.put(w, val+1);
		});
    }
}
