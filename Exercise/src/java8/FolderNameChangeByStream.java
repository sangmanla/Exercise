package java8;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

public class FolderNameChangeByStream {
    public static void main(String[] args) {
	String path = "C:/Users/sam/Desktop/job & app/Áö¿ø¼­/201808";
	File[] fs = new File(path).listFiles();
	
	Arrays.stream(fs)
		.map(dir->Paths.get(dir.getName()).getFileName().toString())
		.filter(dirName->dirName.startsWith("2018"))
		.forEach(dirName -> {
		    File source = new File(path + File.separator + dirName);
		    File target = new File(path + File.separator + dirName.substring(9, dirName.length()) + "_" + dirName.substring(0, 8));
		    target.mkdirs();
		    source.renameTo(target);
		    
		    Arrays.stream(source.listFiles()).forEach(
			    file->{
				file.renameTo(new File(target.getPath() + File.separator + file.getName()));
			    });
		});
    }
}