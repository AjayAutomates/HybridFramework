package javaProgramsInterviewPrep;

public class ArrayWithSum10 {

	public static void main(String[] args) {
		int[] arr={1,2,3,4,5};
		for(int i=0;i<arr.length-2;i++) {
			for(int j=i+1;j<arr.length-1;j++) {
				for(int k=j+1;k<arr.length;k++) {
					if((arr[i]+arr[j]+arr[k])>=10) {
						System.out.println(arr[i]+"+"+arr[j]+"+"+arr[k]);
					}
				}
			}
		}
	}

}
