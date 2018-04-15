public class Generic<T> {

	public Generic() {
	}
	
	public void print(T a)
	{
		if(a instanceof Integer)
			System.out.println("Interger Tpye : " + a);
		
		else if(a instanceof String)
			System.out.println("String Tpye : " + a);
		
		else if(a instanceof Character)
			System.out.println("Character Tpye : " + a);
	}
	
	public static void main(String[] args) 
	{
		Generic<Integer> test1 = new Generic<Integer>();
		Generic<Character> test2 = new Generic<Character>();
		Generic<String> test3 = new Generic<String>();
		
		test1.print(1); 
		test2.print('1'); 
		test3.print("1");
		
		test1.print(2);
		test2.print('a');
		test3.print("String");
	}
}