package DB;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class EMPLOYEE_JOB_ASSIGNMENTS {

	static String[] randomAddress = {"320 Front St W #1400, Toronto, ON M5V 3B6", "Cotton Way, Honeydew, Britsh Columbia, V5D-8F5", "Blue Forest Heath, Venus, Britsh Columbia, V2B-7J0", "Quiet Autumn Circle, Beehive, Nova Scotia", "Crystal Horse End, Ox Level, Northwest Territories", "Cinder Deer Mountain, Suspension, Nova Scotia",
									"Harvest Hills Wharf, Lucky Shot Landing, Ontario, K1T-5E1", "Easy Treasure Field, Crockett, Newfoundland, A6S-1T6", "Jagged Pike, Happy Jack, Nunavut, X3C-0T2", "Cotton Cape, Tees Toh, Newfoundland, A0T-5E1", "Amber Zephyr Court, Tombstone, Newfoundland",
									"Colonial Branch Villas, Whiskey Springs, Northwest Territories", "Dewy Horse Boulevard, Kykotsmovi Village, Saskatchewan", "Quiet Cape, Black Hawk, Britsh Columbia, V9S-0X5", "Shady Beacon Knoll, Reverse, Saskatchewan","Amber Terrace, Big Sky, Britsh Columbia",
									"Heather Grounds, Chignik, Britsh Columbia", "Sunny Bank, Truly, Saskatchewan, S1W-2Q8", "Green Vale, Echo, Saskatchewan, S2I-4J7", "Broad Wagon Estates, Red Wash, Saskatchewan", "Dusty Glen, Poverty, Yukon, Y5Y-5O8, CA", 
									"Velvet Willow Walk, Quinhagak, Britsh Columbia", "Old Forest Trail, Pinto, Britsh Columbia", "Gentle Treasure Cove, Mock City, Prince Edward Island, C2X-7T7", "Hidden Wynd, Cowboys Heaven, Quebec, G2Q-3E0", "Noble Anchor Swale, Zoar, New Brunswick, E1X-2W7",
									"Quiet Creek Autoroute, Judge Town, Nunavut, X3A-7Q3", "Gentle Willow Ramp, Dodge City, Manitoba, R7Q-9A7", "Iron Wagon Port, Hardshell, Nunavut, X4E-5X3", "Blue Key, Dumblane, Ontario, N2K-2T4", "Cozy Cloud Alley, McCool, Ontario, K6I-2C0",
									"Tawny Knoll, Nightmute, Ontario, M4Z-4B1", "Burning Blossom Via, Tukwila, Nunavut, X0X-2Z6", "Grand Run, Tumwater, Manitoba, R4G-8N2", "Silver Boulevard, Madrid, Nunavut", "Crystal Glen, Burnt Prairie, Northwest Territories",
									"Blue Path, Honeydew, Newfoundland, A4X-5O4", "Wishing Embers Ledge, Mormon Bar, Nunavut, X6L-2E8", "Tawny Cider Court, No Mirage, Northwest Territories", 	"Old Gate Way, Wimp, Newfoundland, A3O-8G0", "Rustic Prairie Falls, Dwarf, Manitoba, R4I-9U2",
									"Sunny Plaza, Village Four, Yukon, Y0L-7T8","Green Lagoon Alley, Last Chance, Prince Edward Island","Silent Apple Glen, Brian Head, Saskatchewan", "Clear Pine Valley, Ox Level, Saskatchewan", "Velvet Nectar Isle, Welcome Home, Quebec",
									"Cozy Log Cape, Joshua Tree, Nunavut", "Foggy Port, Volcanoville, Saskatchewan", "Iron Circle, Hongking, Saskatchewan", "Quiet By-pass, Shungopavi, Yukon", "Velvet Cove, Mount Massive Lakes, Saskatchewan"}; 
	public static void main(String[] args) {
		String fCsvFilePath = "C:\\Users\\sam\\test\\src\\csv\\f.csv";
		String lCsvFilePath = "C:\\Users\\sam\\test\\src\\csv\\l.csv";
		
		BufferedReader reader = null;
		String csvSplitBy = System.lineSeparator();
		ArrayList<String> fNames = getData(fCsvFilePath, reader, csvSplitBy);
		ArrayList<String> lNames = getData(lCsvFilePath, reader, csvSplitBy);
		
		for(int i=0;i<100;i++){
			System.out.println("INSERT INTO EMPLOYEE_JOB_ASSIGNMENTS(EMPLOYEE_ID, DATES_STARTED, DEPARTMENT_ID, JOB_CODE, SUPERVISOR_EMPLOYEE_ID, DATE_FINISHED, ASSIGNMENT_DETAILS)");
			System.out.println("VALUES (" + getRandom(50) + ", (SYSDATE - " + getRandom(30) + "), " + getRandom(4) + ", (SELECT JOB_CODE FROM (SELECT ROWNUM AS RN, JOB_CODE FROM REF_JOB_CODES) WHERE RN = " + getRandom(10) + "), " + getRandom(4) + ", (" + (i%3==0?"SYSDATE - " + getRandom(30) : "null") + "), null);");
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
