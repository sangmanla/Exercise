package designpattern.decorator.schema;

public class CriticalWarrior extends DecoratedWorrior {

    public CriticalWarrior(Warrior warrior) {
	super(warrior);
    }

    @Override
    public void shout() {
	System.out.println("I am critical warrior. I will shout loudly.");
	myWarrior.shout();
    }

    @Override
    public void fight() {
	System.out.println("I will fight widly because I am a critical worrior.");
	myWarrior.fight();
    }
}