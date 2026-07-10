package javaProgramsInterviewPrep;

public class ReverseNumber {

	public static void main(String[] args) {
		int n=4356;
		/*int temp=0,reverse=0;
		while(n>0) { 
			temp=n%10;
			reverse=reverse*10+temp;//0*10+6=6   6*10+5=65
			n=n/10;
		}*/
		String s=Integer.toString(n);
		StringBuilder str=new StringBuilder(s);
		System.out.println(str.reverse());

	}

}
