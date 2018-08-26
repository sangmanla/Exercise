package aXXXsGroupCodingInterview;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {

	public static void main(String[] args) {
		Task2 t = new Task2();
//		int result = t.solution("Sun 10:00-20:00\n"+
//				"Fri 05:00-10:00\n"+
//				"Fri 16:30-23:50\n"+
//				"Sat 10:00-24:00\n"+
//				"Sun 01:00-04:00\n"+
//				"Sat 02:00-06:00\n"+
//				"Tue 03:30-18:15\n"+
//				"Tue 19:00-20:00\n"+
//				"Wed 04:25-15:14\n"+
//				"Wed 15:14-22:40\n"+
//				"Thu 00:00-23:59\n"+
//				"Mon 05:00-13:00\n"+
//				"Mon 15:00-21:00");

		int result = t.solution("Mon 01:00-23:00\n"+
"Tue 01:00-23:00\n"+
"Wed 01:00-23:00\n"+
"Thu 01:00-23:00\n"+
"Fri 01:00-23:00\n"+
"Sat 01:00-23:00\n"+
"Sun 01:00-21:00");
		System.out.println(result);
	}
	public int solution(String S){
		S = S.replaceAll("Mon", "0")
			.replaceAll("Tue", "1")
			.replaceAll("Wed", "2")
			.replaceAll("Thu", "3")
			.replaceAll("Fri", "4")
			.replaceAll("Sat", "5")
			.replaceAll("Sun", "6");
		
		List<int[]> newList = Arrays.stream(S.split("\n"))
								.sorted()
								.map(s->getMinsFromMonZero(s))
								.collect(Collectors.toList());
		
		int maxMins = 0, prevEnd = 0;
		for(int i=0;i<newList.size();i++){
			int[] temp = newList.get(i);
			if(i==0){
				if(temp[0]!=0){
					maxMins = temp[0];
				}
			}else{
				int restTime = temp[0] - prevEnd;
				if(restTime > maxMins) maxMins = restTime;
			}
			
			prevEnd = temp[1];
			
			if(i == newList.size()-1){
				int sunLastTime = (6 * 24 * 60) + (24 * 60);
				int lastRestDuration = sunLastTime - prevEnd;
				if(lastRestDuration > maxMins) maxMins = lastRestDuration;
			}
		}		
		
		return maxMins;
	}
	
	public int[] getMinsFromMonZero(String str){
		int mins[] = new int[2];
		int day = Integer.parseInt(str.substring(0, 1));
		int startHour = Integer.parseInt(str.substring(2, 4));
		int startMin = Integer.parseInt(str.substring(5, 7));
		int endHour = Integer.parseInt(str.substring(8, 10));
		int endMin = Integer.parseInt(str.substring(11, 13));
		
		mins[0] = (day * 24 * 60) + (startHour * 60) + startMin;
		mins[1] = (day * 24 * 60) + (endHour * 60) + endMin;
		
		return mins;
	}
}