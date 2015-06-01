package mayzel.patternMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneMatching {

	private static final Pattern PHONE_PATTERN = Pattern.compile("(1-?\\s*)?(\\d{3}-?\\s*){2}\\d{4}-?");
	
	public static void main(String []args){
		String text = "This is my number, 1-123-456-7890. Give ma a call. "
		 		+ "Otherwise call me on this other number 1 718      222 2222";
		 Matcher m = PHONE_PATTERN.matcher(text);
		 boolean b = m.matches();
		 System.out.println(b);
		 
		 while(m.find()){ //repeatedly call it, like calling iterator.next() till find it and then returns it
			 String number = text.substring(m.start(), m.end());
			 String newNum  = number.replaceAll("(\\s){1,}", "-");
			 System.out.println(newNum);
		 }
		 
	}

}
