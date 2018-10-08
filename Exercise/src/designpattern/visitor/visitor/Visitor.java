package designpattern.visitor.visitor;

import designpattern.visitor.element.HouseRoomInterface;
import designpattern.visitor.element.concrete.BedRoom;
import designpattern.visitor.element.concrete.DiningRoom;
import designpattern.visitor.element.concrete.LivingRoom;
import designpattern.visitor.element.concrete.WashRoom;

public class Visitor implements VisitorInterface {
    @Override
    public void visit(HouseRoomInterface houseRoom) {
	if(houseRoom instanceof BedRoom){
	    System.out.println("Sleep in the bedroom.");
	}else if(houseRoom instanceof DiningRoom){
	    System.out.println("Have delicious dinner in the dinning room.");
        }else if(houseRoom instanceof LivingRoom){
            System.out.println("Watch news in the living room.");
        }else if(houseRoom instanceof WashRoom){
            System.out.println("Take a shower in the washroom.");
        }
    }
}