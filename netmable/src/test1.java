import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class test1 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		long n=1000000;
		System.out.println("결과: " + solution(n));
		long end = System.currentTimeMillis();
		System.out.println("실행시간 :"+(end-start/1000.0));
	}
	
	public static long solution(long l) {
		ArrayList<Long> list = new ArrayList<>();
	    HashSet<Long> set = new HashSet<>();
	    long n2 = l*l;
	    set.add((long) 1);
	    set.add((long) 4);
	    for (int i = 2; i < l; i++) {
//	    	if(set.contains(i))
//	    		continue;
	        long j = (long)i*(long)i;
	        while(j < n2) {
	            set.add(j);
	            j *= (long)i;
	        }
	    }
	    list.addAll(set);
	    System.out.println(list.size());
	    Collections.sort(list);
	    long answer = list.get((int) (l-1));
	    return answer;
    }
}
