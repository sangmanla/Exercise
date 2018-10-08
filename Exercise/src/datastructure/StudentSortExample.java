package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class StudentSortExample {
    int mark = 0;
    String name = "";
    static String[] names = {"sam", "aria", "zebra", "bibab", "jonadan", "khim", "eury", "mario", "niro", "fifa"};
    public StudentSortExample(int mark, String name){
	this.mark = mark;
	this.name = name;
    }
    
    @Override
    public String toString() {
        return name + " (" + mark + ")";
    }
    
    public static void main(String[] args) {
	Random ran = new Random();
	List<StudentSortExample> list = new ArrayList<StudentSortExample>();
	IntStream.range(0, 10).forEach(x -> list.add(new StudentSortExample(ran.nextInt(10), names[x])));
	
	list.sort((x, y) ->{
	    if(x.mark > y.mark) return 1;
	    else if (x.mark < y.mark) return -1;
	    else{
		return x.name.compareTo(y.name);
	    }
	});
	
	list.forEach(System.out::println);
    }
}
