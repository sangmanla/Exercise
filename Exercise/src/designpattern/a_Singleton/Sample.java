package designpattern.a_Singleton;

public class Sample {
	private Sample(){};
	private static class SingletonHandler{
		private static final Sample instance = new Sample();
	}
	public Sample getInstance(){
		return SingletonHandler.instance;
	}
}