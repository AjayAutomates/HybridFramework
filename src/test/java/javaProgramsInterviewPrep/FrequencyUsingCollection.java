package javaProgramsInterviewPrep;
import java.util.*;

public class FrequencyUsingCollection {
	public static void main(String[] args) {
		String s="Ajay Automation";
		s=s.toLowerCase();
		Map<Character,Integer> m=new LinkedHashMap<Character, Integer>();
		//{A-->2,j-->1,a-->1,y-->1, -->1}
		for(char i:s.toCharArray()) {//a,j
			if(m.containsKey(i)) {//checks if Key(i) is present in map(m)
				//a
				m.put(i, m.get(i)+1);//-->m.put(A,m.get(A)+1)
				//m.put(a,1+1)
			}
			else {
				m.put(i, 1);//a-->2, j-->1, y-->1
			}
		}
		System.out.println(m);//
		
		Map.Entry<Character, Integer> max=null;
		Map<Character, Integer> map=new LinkedHashMap<Character, Integer>();
		
		for(Map.Entry<Character, Integer> i:m.entrySet()) {
			if(max==null||i.getValue()<max.getValue()) {
				max=i;//max=a-->4
			}
		}
		for(Map.Entry<Character, Integer> i:m.entrySet()) {
			if(i.getValue()==max.getValue()) {
				map.put(i.getKey(), i.getValue());
			}
		}
		System.out.println("maximum Character="+max.getKey()+":"+max.getValue());
		System.out.println(map);
	}

}
