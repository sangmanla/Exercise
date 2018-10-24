import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConnectedByOrdersTest {
    public static void main(String[] args) {
	List<Order> os = new ArrayList<Order>();
	IntStream.range(0, 10).forEach(idx -> os.add(new Order(idx)));
	IntStream.range(0, 3).forEach(idx -> os.add(new Order(10 + idx, 3)));
	IntStream.range(0, 2).forEach(idx -> os.add(new Order(13 + idx, 6)));

	List<Order> sortedOrders = os.stream().sorted((x, y) -> {
	    if(x.pId!=null && y.pId == null) return Integer.compare(x.pId, y.id);
	    else if(x.pId!=null && y.pId!=null) return Integer.compare(x.pId, y.pId);
	    else return Integer.compare(x.id, y.id);
	}).collect(Collectors.toList());

	sortedOrders.stream().forEach(System.out::println);
    }
}

class Order {
    public Order(int id) {
	this.id = id;
    }

    public Order(int id, int pid) {
	this.id = id;
	this.pId = pid;
    }

    Integer id = null;
    Integer pId = null;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getpId() {
	return pId;
    }

    public void setpId(Integer pId) {
	this.pId = pId;
    }

    @Override
    public String toString() {
	return "id:" + id + "\t pid:" + pId;
    }
}