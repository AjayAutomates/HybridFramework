package javaProgramsInterviewPrep;

public class FactorialRecursion {
	public static int factorial(int n) {//1
		if(n==0||n==1) {//base condition
			return 1;
		}
		return n*factorial(n-1);
		//5*factorial(4)=5*4*factorial(3)=5*4*3*factorial(2)=5*4*3*2*factorial(1)
		//5*4*3*2*1
	}
	public static void main(String args[]) {
		System.out.println(factorial(5));
	}

}
