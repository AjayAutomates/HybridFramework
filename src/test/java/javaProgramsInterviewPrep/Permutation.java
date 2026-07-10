package javaProgramsInterviewPrep;

import java.util.Arrays;

public class Permutation {

	public static void main(String[] args) {
		 int[] arr={1,2,3,4};
		 //123
		 //132
		 //231
		 //213
		 //321
		 //312
		 Arrays.sort(arr);//123
		 while(true) {
			 System.out.println(Arrays.toString(arr));//132
			 //first decreasing element from right
			 int i=arr.length-2;//1
			 while(i>=0&&arr[i]>=arr[i+1]) {//1>=0&&3>=2
				 i--;//0
			 }
			 //no such element
			 if(i<0)
				 break;
			 //next greater element
			 int j=arr.length-1;//2
			 while(arr[j]<=arr[i]) {//2<=3
				 j--;//1
			 }
			 //swap the values
			 swap(arr,i,j);//132,0,1==>312
			 //reverse remaining
			 reverse(arr,i+1,arr.length-1);//312,1,2==>132
		 }

	}
	static void swap(int[] arr,int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	static void reverse(int[] arr, int i, int j) {//312,1,2
		while(i<j) {//1<2  2>1
			swap(arr,i++,j--);//312,2,1==>321,3,0==>213
		}
	}

}
