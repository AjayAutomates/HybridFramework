package javaProgramsInterviewPrep;

public class FrequencyOfCharacters {

	public static void main(String[] args) {
		String s="Ajay Automation";
		int count;
		s=s.toLowerCase();//automation
		int max=0;
		char maxchar=' ';
		boolean[] arr=new boolean[s.length()];//{f,f,f,f,t,t,f..}//tocheckvisited charavcter
		for(int i=0;i<s.length();i++) {//0,1,2,3,4,5,6
			count=1;
			if(arr[i]==false) {
				for(int j=i+1;j<s.length();j++) {//2
					if(s.charAt(i)==s.charAt(j)) {//u==
						count++;//2
						arr[j]=true;
					}
				}
				
				System.out.println(s.charAt(i)+" "+count);
			}
			
		}
		

	}

}
