import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class first2020_2 {
	
	static ArrayList<Integer> list;
	static int result = 0;
	static String expression;
	static ArrayList<Character> ch;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		expression="100-200*300-500+20";
//		expression="50*6-3*2";
		
//		���ڿ� ������ ��������Ʈ �����
		StringTokenizer stk = new StringTokenizer(expression,"-|+|*");
		int stk_cnt=stk.countTokens();
		list = new ArrayList<Integer>();
		
		for (int i = 0; i < stk_cnt; i++) {
		
			list.add(Integer.parseInt(stk.nextToken()));
		
		}
		
		ch = new ArrayList<Character>();
//		���� ����
		
		for (int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*') {
				ch.add(expression.charAt(i));
			}
		}
		
//		����
		ArrayList<Character> charlist = new ArrayList<Character>();
		if(expression.contains("+")) {
			charlist.add('+');
		}
		
		if(expression.contains("-")) {
			charlist.add('-');
		}
		
		if(expression.contains("*")) {
			charlist.add('*');
		}
		
		permutation(charlist,new boolean[charlist.size()],0,charlist.size(), new char[charlist.size()]);
		
		System.out.println(result);
		
	}
	
	public static int cal(int a,int b, char c) {
		if(c=='-') return a-b;
		
		else if( c== '+') return a+b;
		
		else return a*b;
	}
	
	private static void permutation(ArrayList<Character> charlist, boolean[] bs, int r, int size, char charr[]) {
		// TODO Auto-generated method stub
		if(r==size) {
			
			ArrayList<Integer> clist = new ArrayList<Integer>();
			clist.addAll(list);
			ArrayList<Character> cch = new ArrayList<Character>();
			cch.addAll(ch);
			
			System.out.println("����");
			
			for (int i = 0; i < charr.length; i++) {
					for (int j = 0; j < cch.size(); j++) {
						if(charr[i]==cch.get(j)){
							clist.set(j, cal(clist.get(j),clist.get(j+1),charr[i]));
							clist.remove(j+1);
							cch.remove(j);
							j--;
							
						}
					}
			
				result=Math.max(result, Math.abs(clist.get(0)));
					
			}
			
			return;
		}
		
		for (int i = 0; i < charlist.size(); i++) {
			
			if(bs[i]) continue;
			
			bs[i]=true;
			charr[r]=charlist.get(i);
			permutation(charlist, bs, r+1, size, charr);
			bs[i]=false;
			
		}
		
	}
	
}
