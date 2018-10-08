package designpattern.composite;

import designpattern.composite.schema.NodeComposite;
import designpattern.composite.schema.NodeFile;

public class DriverClass {
    public static void main(String[] args) {
	NodeComposite nc = new NodeComposite("dir1");
	nc.addNode(new NodeFile("file1"));
	nc.addNode(new NodeComposite("dir2"));
	
	NodeComposite nc2 = new NodeComposite("root");
	nc2.addNode(nc);
	
	nc2.showNodes();
    }
}
