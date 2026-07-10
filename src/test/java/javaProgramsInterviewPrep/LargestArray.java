package javaProgramsInterviewPrep;

import java.util.Arrays;

public class LargestArray {

	public static void main(String[] args) {
		int[] a= {3,4,16,2,7,8,2,12,5};
		//Arrays.sort(a);
		//System.out.println(a[a.length-1]);
		int max=a[0];//3
		for(int i=0;i<a.length;i++) {//0,1,2,3
			if(max<a[i]) {//16<2
				max=a[i];//16
			}
		}
		System.out.println(max);

	}

}
