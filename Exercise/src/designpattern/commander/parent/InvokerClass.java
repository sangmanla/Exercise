package designpattern.commander.parent;

public class InvokerClass {
    CommanderInterface ci;
    
    public void setCommander(CommanderInterface in){
	ci = in;
    }
    public void invoke(){
	ci.execute();
    }
}
