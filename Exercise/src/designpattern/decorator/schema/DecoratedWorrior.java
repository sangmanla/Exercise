package designpattern.decorator.schema;

public abstract class DecoratedWorrior implements Warrior {
    protected Warrior myWarrior;

    public DecoratedWorrior(Warrior warrior) {
	this.myWarrior = warrior;
    }
}