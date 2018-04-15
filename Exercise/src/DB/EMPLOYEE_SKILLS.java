package DB;
import java.util.concurrent.ThreadLocalRandom;

public class EMPLOYEE_SKILLS {

	static String[] skillLvls = {"M", "P", "O", "J", "B"};
	
	public static void main(String[] args) {
		for(int i=0;i<50;i++){
			for(int j=0;j<11;j++){
				System.out.println("INSERT INTO EMPLOYEE_SKILLS(EMPLOYEE_ID, SKILL_ID, DATE_SKILL_ACQUIRED, SKILL_LEVEL_CODE)");
				System.out.println("VALUES (" + i + ", " + j +", SYSDATE - "+ gr(365) + ", '" + skillLvls[gr(skillLvls.length)] + "' );");
			}
		}
	}

	private static int gr(int length) {
		return ThreadLocalRandom.current().nextInt(0, length);
	}
}
