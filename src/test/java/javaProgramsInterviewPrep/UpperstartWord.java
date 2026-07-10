package javaProgramsInterviewPrep;

public class UpperstartWord {

	public static void main(String[] args) {
		String s="hello world";
		s=" "+s.trim();// hello world
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==' ') {
				s=s.replace(s.charAt(i+1), Character.toUpperCase(s.charAt(i+1)));
				// Hello World
			}
		}
		System.out.println(s);
		

	}

}
