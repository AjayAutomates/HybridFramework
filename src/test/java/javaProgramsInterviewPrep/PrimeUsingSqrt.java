package javaProgramsInterviewPrep;

public class PrimeUsingSqrt {

	public static void main(String[] args) {
		int n=5,c=0;//divide the number from 2 till sqrt and if 0 then not prime
		for(int i=2;i<=Math.sqrt(n);i++) {//
			if(n%i==0) {//5%2==0
				c=1;
				break;
			}
		}
		if(c==0) {
			System.out.println(n+"is a primeno");
		}
		else {
			System.out.println(n+" is not  PRIME");
		}

	}

}
