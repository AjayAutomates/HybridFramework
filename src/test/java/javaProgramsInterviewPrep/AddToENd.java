package javaProgramsInterviewPrep;

public class AddToENd {

	public static void main(String[] args) {
		int[] a={0,1,2,1,4,1,1,10,1};
		int b[]=new int[a.length];
	       int count=0;
	       for(int i=0;i<a.length;i++){
	           if(a[i]!=1){
	              b[count]=a[i];
	              count++;//3
	           }
	       }//{0,2,4,10,0,0,0,0,0}
	       while(count<a.length){
	           b[count]=1;
	           count++;
	       }
	       for(int k:b){
	           System.out.print(k+" ");
	       }

	}

}
