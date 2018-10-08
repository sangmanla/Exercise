package designpattern.decorator.schema;

public class KindWarrior extends DecoratedWorrior {

    public KindWarrior(Warrior warrior) {
	super(warrior);
    }

    @Override
    public void shout() {
	System.out.println("I am kind warrior. I won't shout at all.");
	myWarrior.shout();
    }

    @Override
    public void fight() {
	System.out.println("I will fight gently because I am a knid worrior.");
	myWarrior.fight();
    }
}