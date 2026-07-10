package javaProgramsInterviewPrep;

public class RevereNumberUsingString {

	public static void main(String[] args) {
		int n=5388929;
		String s=Integer.toString(n);
		StringBuilder str =new StringBuilder(s);
		System.out.println(str.reverse());
		int num=Integer.parseInt(str.toString());
		System.out.println(num);

	}

}
