import java.io.*;
import java.util.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class Password{
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("password.dat"));
		f.nextLine();
		while(f.hasNext()){
			String raw = f.nextLine();
			boolean isValid = true;
			String ret = "";
			if(raw.length()<8){
				isValid = false;
				ret+="Less than 8 characters. ";
			}
			if(containsSpace(raw)){
				isValid = false;
				ret+="Contains white space. ";
			}
			if(raw.toLowerCase().equals(raw)){
				isValid = false;
				ret+="Missing capital letter. ";
			}
			if(!containsNumber(raw)){
				isValid = false;
				ret+="Missing number. ";
			}
			if(!containsSymbol(raw)){
				isValid = false;
				ret+="Missing symbol. ";
			}
			if(isValid)
				out.println("Valid");
			else
				out.printf("Invalid %s%n",ret);
		}
	}
	
	public static boolean containsSpace(String s){
		String space = " ";
		for(char ch:s.toCharArray())
			if(space.contains(ch+""))
				return true;
		return false;
	}
	
	public static boolean containsNumber(String s){
		String nums = "1234567890";
		boolean ret = false;
		for(char ch:s.toCharArray())
			if(nums.contains(ch+""))
				ret = true;
		return ret;
		
	}
	
	public static boolean containsSymbol(String s){
		String nums = "!@#$%^&*()/\\\'\"[]{}";
		boolean ret = false;
		for(char ch:s.toCharArray())
			if(nums.contains(ch+""))
				ret = true;
		return ret;
		
	}
	
	
}