package javaProgramsInterviewPrep;

import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		int[] a= {2,6,8,1,4,5,9,1,3,7};
		/*for(int i=0;i<a.length;i++) {//0
			for(int j=i+1;j<a.length;j++) {//1,2,3
				if(a[i]>a[j]) {//a[0]>a[3]==>2>1a[i]=2,a[j]=1
					int temp=a[i];//2
					a[i]=a[j];//a[0]=1
					a[j]=temp;//a[3]=2//a[i]=1a[j]=2
				}//{1,6,8,2,4,5,9,1,3,7}
			}
		}*/
		Arrays.sort(a);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}

	}

}
