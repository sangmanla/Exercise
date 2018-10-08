package designpattern.decorator.schema;

public final class BasicWarrior implements Warrior {

    @Override
    public void shout() {
    	System.out.println("shout!");
    }

    @Override
    public void fight() {
	System.out.println("fight!");
    }
}