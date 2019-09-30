package ppc;

import java.util.stream.IntStream;

public class Singleton {
	private Singleton() { };
	
	private static class Holder {
		static final Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInstance(){
		return Holder.INSTANCE;
	}
	
	public static void main(String[] args) {
		IntStream.iterate(0, i -> i + 1)
		.skip(5)   // OFFSET
        .limit(10) // LIMIT
        .forEach(System.out::println);
	}
}
