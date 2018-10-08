package designpattern.commander;

import designpattern.commander.parent.CommanderInterface;

public class CommandExecutor2 implements CommanderInterface{

    @Override
    public void execute() {
	System.out.println("in commander2");
    }
}