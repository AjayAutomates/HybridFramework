package javaProgramsInterviewPrep;
import java .util.*;

public class FiestNonRepeatingcharac {

	public static void main(String[] args) {
		String s="Ajay Automation";
		s=s.toLowerCase();
		Map<Character,Integer> m=new LinkedHashMap<Character,Integer>();
		for(char i:s.toCharArray())
		{
			m.put(i, m.getOrDefault(i,0)+1);//m.put(i,m.get(i)+1)
		}
		for(Map.Entry<Character, Integer> i:m.entrySet()) {
			if(i.getValue()==1) {
				System.out.println("FirstNonrepeatedCharcter:"+i.getKey()+" :"+i.getValue());
				break;
			}
		}

	}

}
