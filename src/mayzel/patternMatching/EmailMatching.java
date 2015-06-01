package mayzel.patternMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMatching {

	private static final Pattern EMAIL_PATTERN = Pattern.compile("\\S+?@\\S+?\\.\\S+");// so not count @ and . so not match them.
	
	public static void main(String [] args){

		 String text = "This is my email avigaylmayzel94@gmail.com email me anytime";
		 Matcher m = EMAIL_PATTERN.matcher(text);
		 boolean b = m.matches();
		 System.out.println(b);
		 
		 while(m.find()){
			 String number = text.substring(m.start(), m.end());
			 System.out.println(number);
		 }
	
	}

}
