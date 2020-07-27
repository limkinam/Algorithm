import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S_2493 {
	
	static class A{
		int v,i;

		public A(int v, int i) {
			super();
			this.v = v;
			this.i = i;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] rs = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		Stack<A> stack = new Stack<>();
		stack.add(new A(arr[N-1],N-1));
		
		
		for (int i = N-2; i >= 0; i--) {
			while(!stack.isEmpty()) {
				A tmp = stack.peek();
				if(arr[i]>tmp.v) {
					rs[tmp.i]=i+1;
					stack.pop();
				}else {
					stack.add(new A(arr[i],i));
					break;
				}
			}
			stack.add(new A(arr[i],i));
		}
		
		for (int i = 0; i < rs.length; i++) {
			System.out.print(rs[i]+" ");
		}
		
	}

}
