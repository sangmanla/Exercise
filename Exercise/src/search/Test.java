package search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		int logFileSize = 5;
		List<String> logLines = new ArrayList<String>();
		logLines.add("a1 9 2 3 1");
		logLines.add("g1 Act car");
		logLines.add("zo4 9 2 3 1");
		logLines.add("ab1 off Key dog");
		logLines.add("a8 Act car2");
		reorderLines(logFileSize, logLines).stream().forEach(System.out::println);
	}
	
	public static List<String> reorderLines(int logFileSize, List<String> logfile) 
	{
		List<String> result = new ArrayList<>();
		List<String> alphas = logfile.stream().filter(s1 -> s1.split(" ", 2)[1].matches("^[ A-Za-z]+$")).
				sorted((s1, s2) -> {
					String[] a = s1.split(" ", 2);
					String[] b = s2.split(" ", 2);
					int val = a[1].compareTo(b[1]);
					if(val!=0) return val;
					else{
						return a[0].compareTo(b[0]);
					}
				}).collect(Collectors.toList());
		List<String> nums = logfile.stream().filter(s1 -> !s1.split(" ", 2)[1].matches("^[ A-Za-z]+$")).collect(Collectors.toList());
		
		result.addAll(alphas);
		result.addAll(nums);
		return result;
	}
}
