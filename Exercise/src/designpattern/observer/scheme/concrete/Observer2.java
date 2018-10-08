package designpattern.observer.scheme.concrete;

import designpattern.observer.scheme.IObserver;

public class Observer2 extends IObserver {
    private String myValue = "2";
    @Override
    public void update(String changedValue) {
	System.out.println("update 2 class");
	System.out.println("before : " + myValue);
	myValue = changedValue;
	System.out.println("after : " + myValue);
    }
}