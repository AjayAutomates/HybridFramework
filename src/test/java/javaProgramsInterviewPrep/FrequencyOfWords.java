package javaProgramsInterviewPrep;

public class FrequencyOfWords {

	public static void main(String[] args) {
		String s="Java is good Java is powerful";
		s=s.toLowerCase();
		String[] words=s.split(" ");
		boolean[] visit=new boolean[words.length];
		int count;
		for(int i=0;i<words.length;i++) {
			count=1;
			if(visit[i]==false) {
				for(int j=i+1;j<words.length;j++) {
					if(words[i].equals(words[j])) {
						count++;
						visit[j]=true;
					}
				}
				System.out.println(words[i]+" "+count);
			}
		}

	}

}
