package designpattern.observer.scheme.concrete;

import designpattern.observer.scheme.IObserver;

public class Observer1 extends IObserver {
    private String myValue = "1";
    
    @Override
    public void update(String changedValue) {
	System.out.println("update 1 class");
	System.out.println("before : " + myValue);
	myValue = changedValue;
	System.out.println("after : " + myValue);
    }
}