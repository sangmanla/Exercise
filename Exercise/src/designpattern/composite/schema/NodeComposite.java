package designpattern.composite.schema;

import java.util.ArrayList;
import java.util.List;

public class NodeComposite implements NodeComponent {
    private String dirName = "";
    private List<NodeComponent> children = new ArrayList<NodeComponent>();
    
    public NodeComposite(){}
    public NodeComposite(String dirName){
	this.dirName = dirName;
    }
    
    @Override
    public String getName() {
	return this.dirName;
    }
    
    public void addNode(NodeComponent node){
	children.add(node);
    }
    
    public void showNodes(){
	System.out.println(getName());
	children.stream().forEach(x ->{
	    if(x instanceof NodeComposite) {
		((NodeComposite)x).showNodes();
	    }else{
		System.out.println(x.getName());
	    }
	});
    }
}