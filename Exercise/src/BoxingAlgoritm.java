import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BoxingAlgoritm {
	public static void main(String[] args) throws IOException{
		String path = "C:/Users/sam/Exercise/Exercise/Exercise/src/BoxingAlgoritm.txt";
		BufferedReader br = new BufferedReader(new FileReader(path));
		boolean readCount = true;
		
		int cnt = 0;
		String line = br.readLine();
		cnt = Integer.parseInt(line);
		
		while((line = br.readLine()) != null){
			if(readCount) {
				
				readCount = false;
			}else{
				curCnt++;
				if(curCnt == curCnt){
					
				}
			}
		}
	}
}
