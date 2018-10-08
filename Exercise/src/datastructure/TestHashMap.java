package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap {

    public static void main(String[] args) {
	Student a = new Student(1, "asjdflasjk");
	Map<Student, Student> map = new HashMap<Student, Student>();
	map.put(a, a);
	System.out.println(map.get(a));
	
	a.id = 1231;
	
	System.out.println(map.get(a));
    }
}

class Student{
    public int id;
    public String name;
    public Student(int a, String b){
	this.id = a;
	this.name = b;
    }
    
    @Override
    public int hashCode() {
        return id + super.hashCode();
    }
}