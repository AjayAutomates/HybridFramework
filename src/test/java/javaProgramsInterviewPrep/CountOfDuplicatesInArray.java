package javaProgramsInterviewPrep;

import java.util.Arrays;

public class CountOfDuplicatesInArray {

	public static void main(String[] args) {
		int[] a= {1,2,4,5,6,8,3,2,2,5,7,9,8,10,11};
		Arrays.sort(a);//{1,2,2,2,3,4,5,5,6,7,8,8,10}
		int count =1;
		for(int i=0;i<a.length-1;i++) {//14-->0,1,2,3,4
			if(a[i]==a[i+1]) {//3==4
				count++;//
			}
			else {
				System.out.println(a[i]+" "+count);//3  1
				count=1;
			}
		}
		if(a[a.length-2]!=a[a.length-1]) {
			System.out.println(a[a.length-1]+" "+1);
		}

	}

}
