package javaProgramsInterviewPrep;

public class Fibonacci {

	public static void main(String[] args) {
		int n=6, a=0, b=1, c;
		System.out.print(a+" "+b);
		for(int i=2;i<n;i++) {
			c=a+b;
			a=b;
			b=c;
			System.out.print(" "+c);
		}

	}

}
