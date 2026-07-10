package javaProgramsInterviewPrep;

public class PrimeOrNot {

	public static void main(String[] args) {
		int n=7,c=0;
		if(n>0) {
			for(int i=1;i<=n;i++) {//1,2,3,4
				if(n%i==0) {//4%4==0
					c++;//3
				}
			}
			if(c==2) {
				System.out.println(n+" is a prime no");
			}
			else {
				System.out.println(n+" is not a prime no");
			}
		}
		else {
			System.out.println(n+" is not a prime no");
		}
		
	}

}
