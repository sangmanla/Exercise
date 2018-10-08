package designpattern.visitor.element;

import designpattern.visitor.visitor.VisitorInterface;

public interface HouseRoomInterface {
    default public void accept(VisitorInterface visitor){
	visitor.visit(this);
    }
}
