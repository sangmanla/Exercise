package designpattern.visitor.element;

import java.util.Arrays;

import designpattern.visitor.element.concrete.BedRoom;
import designpattern.visitor.element.concrete.DiningRoom;
import designpattern.visitor.element.concrete.LivingRoom;
import designpattern.visitor.element.concrete.WashRoom;
import designpattern.visitor.visitor.VisitorInterface;

public class House implements HouseRoomInterface {
    HouseRoomInterface[] rooms;
    
    public House(){
	rooms = new HouseRoomInterface[]{new BedRoom(), new DiningRoom(), new LivingRoom(), new WashRoom()};
    }
    @Override
    public void accept(VisitorInterface visitor) {
	Arrays.stream(rooms).forEach(x -> x.accept(visitor));
    }
}