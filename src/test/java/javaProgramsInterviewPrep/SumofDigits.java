package javaProgramsInterviewPrep;

public class SumofDigits {

	public static void main(String[] args) {
		int n=4356;//4+3+5+6
		int temp=0,sum=0;
		while(n>0) {//4356>0   435>0   43>0          4>0
			temp=n%10;//4356%10=6  435%10=5  43%10=3  4%10=4
			sum+=temp;//sum=0+6=6  6+5=11    11+3=14  14+4=18
			n=n/10;//n=4356/10=435 435/10=43 43/10=4  4/10=0
		}
		System.out.println(sum);
	}
}
