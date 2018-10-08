package datastructure.hierarchical;

public class Dog extends Animal {

    public Dog(int age, String name) {
	super(age, name, AnimalType.Dog);
    }
    
    @Override
    public void bark() {
	System.out.println("bak bak");
    }
}
