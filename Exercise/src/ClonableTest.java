import java.io.Serializable;

public class ClonableTest implements Cloneable, Serializable{
	int a, b;
	String c = "123";
	
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		ClonableTest aa = new ClonableTest();
		aa.a = 10;
		aa.b = 20;
		ClonableTest bb = (ClonableTest)aa.clone();
		System.out.println(aa);
		System.out.println(bb);
		
		aa.a = 100;
		aa.c = "234";
		System.out.println(aa);
		System.out.println(bb);
	}
	
	@Override
	public String toString() {
		return "A : " + a + " | B : " + b + " |  c : " + c;
	}

}
