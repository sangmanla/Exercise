import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StreamExample {

   public static void main( String args[] ) {
//      // String to be scanned to find the pattern.
//      String line = "This order was placed for QT3000! OK?";
//      String pattern = "(.*)(\\d+)(.*)";
//
//      ArrayList a;
//      // Create a Pattern object
//      Pattern r = Pattern.compile(pattern);
//
//      // Now create matcher object.
//      Matcher m = r.matcher(line);
//      if (m.find( )) {
//         System.out.println("Found value: " + m.group(0) );
//         System.out.println("Found value: " + m.group(1) );
//         System.out.println("Found value: " + m.group(2) );
//      }else {
//         System.out.println("NO MATCH");
//      }
	   
	   int oldCapacity = 0;
	   int newCapacity = oldCapacity + (oldCapacity >> 1);
	   int newCapacity2 = oldCapacity + (oldCapacity / 2);
	   
	   System.out.println(newCapacity);
	   System.out.println(newCapacity2);
   }
}