package javaProgramsInterviewPrep;
import java.util.*;

public class LongeststringList {

	public static void main(String[] args) {
		List<String> l=Arrays.asList("Ajay","is","Automation");
		String longest="";
		for(String s:l) {//Ajay,is,Automation
			if(s.length()>longest.length()) {//4>0,2>4,10>4
				longest=s;//Automation
			}
		}
		System.out.println(longest);
		

	}

}
