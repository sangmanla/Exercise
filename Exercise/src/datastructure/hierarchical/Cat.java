package datastructure.hierarchical;

public class Cat extends Animal{

    public Cat(int age, String name) {
	super(age, name, AnimalType.Cat);
    }

    @Override
    public void bark() {
	System.out.println("miyaon");
    }
}

