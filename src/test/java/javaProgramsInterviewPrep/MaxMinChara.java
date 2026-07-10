package javaProgramsInterviewPrep;
import java.util.*;

public class MaxMinChara {

	public static void main(String[] args) {
		String s ="I love Java the Most";
		s=s.toLowerCase();
		Map<Character,Integer> m=new LinkedHashMap<Character,Integer>();
		for(char i:s.toCharArray()) {
				m.put(i,m.getOrDefault(i,0)+1);
		}
		Map.Entry<Character, Integer> max=null;
		Map.Entry<Character, Integer> min=null;
		for(Map.Entry<Character, Integer> i:m.entrySet()) {
			if(max==null||i.getValue()>max.getValue()) {
				max=i;
			}
			if(min==null||i.getValue()<min.getValue()) {
				min=i;
			}
		}
		System.out.println("maximum Character="+max.getKey()+max.getValue());
		System.out.println("minimum Character="+min.getKey()+min.getValue());
	}

}
