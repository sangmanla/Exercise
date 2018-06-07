import java.io.Serializable;

public class TestA implements Serializable{
	public int a = 10;
	
	public void test1() throws Throwable{
		System.out.println("in Test A");
		this.finalize();
	}
	
	public static void main(String[] args) throws Throwable {
//		System.out.println(1);
//		new TestA().test1();
//		System.out.println(2);
//		Runtime.getRuntime().exec("notepad");
//		System.out.println(Runtime.getRuntime().totalMemory());
//		System.out.println(Runtime.getRuntime().freeMemory());
		
		for(int i=0;i<100000;i++){
			new TestA();
		}
		System.out.println(Runtime.getRuntime().freeMemory());
		System.gc();
		System.out.println(Runtime.getRuntime().freeMemory());
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
}