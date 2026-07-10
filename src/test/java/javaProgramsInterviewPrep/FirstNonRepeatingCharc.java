package javaProgramsInterviewPrep;

public class FirstNonRepeatingCharc {

	public static void main(String[] args) {
		String s="aabbcc";
		int flag=0;
		for(char i:s.toCharArray()) {//a,a
			if(s.indexOf(i)==s.lastIndexOf(i)) {//0==1
				flag=1;
				System.out.println("FirstNonRepeatingCharacter:"+i);
				break;
			}
		}
		if(flag==0) {
			System.out.println("No non repeating character");
		}

	}

}
