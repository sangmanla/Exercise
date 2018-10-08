package designpattern.observer.scheme;

import java.util.ArrayList;
import java.util.List;

public class ObserverMgmtClass {
    private String myValue = "firstValue";
    List<IObserver> list = new ArrayList<IObserver>();
    public void registerObserver(IObserver observer){
	list.add(observer);
    }
    public void unRegisterObserver(IObserver observer){
	list.remove(observer);
    }
    
    public void setValue(String value){
	myValue = value;
	notifyObservers();
    }
    
    public void notifyObservers(){
	list.forEach(x -> x.update(myValue));
    }
}
