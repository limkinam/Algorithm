import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class first2020_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String gems[] = {"DIA","RUBY","RUBY","DIA","DIA","EMERALD","SAPPHIRE","DIA"};
//      String [] gems = {"AA","AB","AC","AA","AC"};
//      String [] gems = {"XYZ","XYZ","XYZ"};
      String [] gems = {"ZZZ","YYY","NNNN","YYY","BBB"};

		int N = gems.length;
		
		TreeSet<Integer> set = new TreeSet<>();
		
		HashMap<String, Integer> map = new HashMap<>();
		
		int result[] = {0,N-1};
		int len = 100001;
		
		for (int i = N-1; i >= 0; i--) {
			if(map.containsKey(gems[i])) {
				set.remove(map.get(gems[i]));
				map.replace(gems[i], i);
				set.add(i);
				if(len >= (set.last() - i) ) {					
					result[0]=i;
					result[1]=set.last();
					len = set.last() - i;
				}
			}
			else {
				set.add(i);
				map.put(gems[i], i);
				result[0]=i;
				len = result[1] - result[0];
			}
		}
		System.out.println((result[0]+1)+" "+(set.last()+1));
		
	}

}
