package datastructure;

public class ReverseWords {

    public static void main(String[] args) {
	String str = "This is a String";
	String result = "";
	char[] chars = str.toCharArray();
	
	StringBuilder word = new StringBuilder();
	for(int i=chars.length-1;i>=0;i--){
	    word.append(chars[i]);
	    
	    if(chars[i] == ' '){
		result = word + result;
		word = new StringBuilder();
	    }
	}
	
	result = word + " " + result.substring(0, result.length()-1);
	
	System.out.println("[" + result + "]");
    }
}
