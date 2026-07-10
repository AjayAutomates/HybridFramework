package javaProgramsInterviewPrep;

public class SumOfDigitsString {

	public static void main(String[] args) {
		String s="Automation642";
		int sum=0;
		for(char i:s.toCharArray()) {
			if(Character.isDigit(i)) {
				sum+=Character.getNumericValue(i);//sum=0+6=6+4=10
			}
		}
		System.out.println(sum);

	}

}
