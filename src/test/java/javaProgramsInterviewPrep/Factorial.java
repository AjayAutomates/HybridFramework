package javaProgramsInterviewPrep;

public class Factorial {

	public static void main(String[] args) {
		int n=5,fact=1;
		for(int i=1;i<=n;i++) {//1,2,3,4,5
			fact*=i;//fact=fact*i=1*1=1*2=2*3=6*4=24*5=120
		}
		System.out.println("Factorial of "+n+ " is "+fact);

	}

}
