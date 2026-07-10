package javaProgramsInterviewPrep;

import java.util.*;

public class RemoveDuplicatesList {

	public static void main(String[] args) {
		List<Integer> l=Arrays.asList(3,5,7,2,3,5,6,7);
		Set<Integer> s=new HashSet<Integer>();
		Set<Integer> duplicate=new HashSet<Integer>();
		for(Integer i:l) {
			if(!s.add(i)) {//3,5,7,2,6
				duplicate.add(i);//3,5
			}
		}
		System.out.println(duplicate);
	}

}
