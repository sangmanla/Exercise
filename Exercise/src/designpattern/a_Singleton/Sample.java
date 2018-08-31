package designpattern.a_Singleton;

public class Sample {
    private Sample() {
    };

    private static class SingletonHandler {
	private static final Sample instance = new Sample();
    }

    public static Sample getInstance() {
	return SingletonHandler.instance;
    }

    public static void main(String[] args) {
	System.out.println(Sample.class);
	Sample a = Sample.getInstance();
	Sample b = Sample.getInstance();
	
	System.out.println(a.equals(b));
    }
}