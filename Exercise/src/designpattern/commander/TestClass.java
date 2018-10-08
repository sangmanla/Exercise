package designpattern.commander;

import designpattern.commander.parent.InvokerClass;

public class TestClass {

    public static void main(String[] args) {
	InvokerClass ic = new InvokerClass();
	ic.setCommander(new CommandExecutor1());
	ic.invoke();
	
	ic.setCommander(new CommandExecutor2());
	ic.invoke();
    }
}