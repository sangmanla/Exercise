package DB;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PERFORMANCE_REVIEWS {

	static String[] randomString = {"Ecellent", "Well", "Good", "Need to improve", "Bad"};
	static String[] randomString2 = {"I think it is ecellent", "I think it is well", "I think it is good", "I think it needs to improve", "I think it is bad"};
	
	public static void main(String[] args) {
		String fCsvFilePath = "C:\\Users\\sam\\test\\src\\csv\\f.csv";
		String lCsvFilePath = "C:\\Users\\sam\\test\\src\\csv\\l.csv";
		
		BufferedReader reader = null;
		String csvSplitBy = System.lineSeparator();
		ArrayList<String> fNames = getData(fCsvFilePath, reader, csvSplitBy);
		ArrayList<String> lNames = getData(lCsvFilePath, reader, csvSplitBy);
		
		for(int i=0;i<50;i++){
			System.out.println("INSERT INTO PERFORMANCE_REVIEWS(EMPLOYEE_ID, DATE_OF_REVIEW, REVIEWED_BY_EMPLOYEE_ID, COMMENTS_BY_REVIEWER, COMMENTS_BY_EMPLOYEE)");
			System.out.println("VALUES (" + i + ", (SYSDATE - " + getRandom(30) + "), " + getRandom(4) +", '"+ randomString[getRandom(5)] + "', '" + randomString2[getRandom(5)] + "' );");
		}
	}

	private static int getRandom(int length) {
		return ThreadLocalRandom.current().nextInt(0, length);
	}

	private static ArrayList<String> getData(String fCsvFilePath, BufferedReader reader, String csvSplitBy) {
		String line;
		ArrayList<String> names = new ArrayList<>();
		try{
			reader = new BufferedReader(new FileReader(fCsvFilePath));
			while((line = reader.readLine()) != null){
				names.add(line.trim());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				reader.close();
			}catch(Exception e){
				e.printStackTrace();;
			}
		}
		return names;
	}
}
