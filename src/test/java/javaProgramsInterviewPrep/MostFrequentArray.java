package javaProgramsInterviewPrep;

import java.util.*;

public class MostFrequentArray {

	public static void main(String[] args) {

		int count=1,max=1;
		int[] a= {2,5,9,7,5,8,9,5};
		/*int maxel=a[0];
		Arrays.sort(a);
		for(int i=1; i<a.length;i++)
		{
			if(a[i]==a[i-1])
			{
				count++;
			}
			else
			{
			System.out.println(a[i-1]+ " " +count);
			 count=1;

			}
			if(count>max) {
				max=count;
				maxel=a[i];
			}
		}
		System.out.println(a[a.length-1]+" " +count);
		System.out.println("Most frequent element "+maxel +" ="+max);*/
		Map<Integer,Integer> freq=new HashMap<Integer,Integer>();
		for(int i:a) {
			freq.put(i, freq.getOrDefault(i,0)+1);
		}
		int maxel=0;
		for(int k:freq.keySet()) {
			if(freq.get(k)>max) {
				max=freq.get(k);
				maxel=k;
			}
		}
		System.out.println("most Frequent"+maxel +"="+max);

	}

}
