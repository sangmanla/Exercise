package DB;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TRAINING_HISTORY {

	static String[] grades = {"A", "B", "C", "D", "F", "P"};
	
	public static void main(String[] args) {
		String fCsvFilePath = "C:\\Users\\sam\\test\\src\\csv\\f.csv";
		String lCsvFilePath = "C:\\Users\\sam\\test\\src\\csv\\l.csv";
		
		for(int i=0;i<100;i++){
			System.out.println("INSERT INTO TRAINING_HISTORY(EMPLOYEE_ID, COURSE_ID, DATE_OF_COURSE, RESULTS)");
			System.out.println("VALUES (" + gr(50) + ", " + gr(9) +", SYSDATE - "+ gr(365) + ", '" + grades[gr(grades.length)] + "' );");
		}
	}

	private static int gr(int length) {
		return ThreadLocalRandom.current().nextInt(0, length);
	}
}
