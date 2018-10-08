package designpattern.composite.schema;

public class NodeFile implements NodeComponent {
    private String fileName = "";
    
    public NodeFile(){}
    
    public NodeFile(String fileName){
	this.fileName = fileName;
    }
    
    @Override
    public String getName() {
	return fileName;
    }
}