package mayzel.patternMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {

	public static void main(String []args){
		//simple
		 Pattern p = Pattern.compile("(1-)?\\d{3}-?\\d{3}-?\\d{4}-?");
		 Matcher m = p.matcher("1-123-456-7890");
		 boolean b = m.matches();
		 System.out.println(b);
		 
	}

}
