package DB;
import java.util.concurrent.ThreadLocalRandom;

public class COURSE_ENROLLMENT {

	public static void main(String[] args) {
		int index = 0;
		for(int i=0;i<50;i++){
			int randomCourseCnt = gr(5) + 1;
			for(int j=0;j<randomCourseCnt;j++){
				String startDateStr = "SYSDATE - "+ gr(365);
				String endDateStr = startDateStr + " + 7";
				System.out.println("INSERT INTO COURSE_ENROLLMENT(ENROLLMENT_ID, EMPLOYEE_ID, COURSE_ID, START_DATE, END_DATE)");
				System.out.println("VALUES (" + index + ", " + i +", " + gr(9) +",  " + startDateStr + ", " + (gr(2)==0?"NULL":endDateStr)  + ");");
				index++;
			}
		}
	}

	private static int gr(int length) {
		return ThreadLocalRandom.current().nextInt(0, length);
	}
}
