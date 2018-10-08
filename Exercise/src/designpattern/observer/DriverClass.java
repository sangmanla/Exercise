package designpattern.observer;

import designpattern.observer.scheme.ObserverMgmtClass;
import designpattern.observer.scheme.concrete.Observer1;
import designpattern.observer.scheme.concrete.Observer2;

public class DriverClass {
    public static void main(String[] args) {
	ObserverMgmtClass oc = new ObserverMgmtClass();
	oc.registerObserver(new Observer1());
	Observer1 ob1 = new Observer1();
	oc.registerObserver(ob1);
	oc.setValue("1111");
	System.out.println("------------------------------");
	oc.unRegisterObserver(ob1);
	oc.registerObserver(new Observer2());
	oc.setValue("2222");
    }
}