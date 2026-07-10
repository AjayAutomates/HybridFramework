package javaProgramsInterviewPrep;
import java.util.*;

public class RemoveduplicatesInString {
	public static void main(String[] args) {
		String s="Automation";
		s=s.toLowerCase();
		Set<Character> set=new HashSet<Character>();
		for(int i=0;i<s.length();i++) {
			set.add(s.charAt(i));		
		}
		System.out.println(set);
	}
}
