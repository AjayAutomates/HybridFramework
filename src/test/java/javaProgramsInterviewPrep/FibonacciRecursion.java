package javaProgramsInterviewPrep;

public class FibonacciRecursion {
	public static int fib(int n) {
		if(n<=1) {
			return n;
		}
		return fib(n-1)+fib(n-2);//fib(2)+fib(1)=fib(1)+fib(0)+1=1+0+1=2
	}

	public static void main(String[] args) {
		for(int i=0;i<7;i++) {
			System.out.println(fib(i));//3
		}

	}

}
