import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S_1197_2 {

	
	static int parents[];
	
	static class E implements Comparable<E>{
		int st,ed,val;

		public E(int st, int ed, int val) {
			super();
			this.st = st;
			this.ed = ed;
			this.val = val;
		}

		@Override
		public int compareTo(E o) {
			// TODO Auto-generated method stub
			return this.val - o.val;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(stk.nextToken());
		int E = Integer.parseInt(stk.nextToken());
		
		PriorityQueue<E> pq = new PriorityQueue<E>();
		
		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(stk.nextToken())-1;
			int B = Integer.parseInt(stk.nextToken())-1;
			int C = Integer.parseInt(stk.nextToken());
			pq.add(new E(A,B,C));
		}
		
		
		
		int result=0;
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < E; i++) {
			E edge = pq.poll();
			if(find(edge.st) == find(edge.ed))
				continue;
			result+=edge.val;
			union(edge.st,edge.ed);
		}
		
		System.out.println(result);
	}

	private static int find(int st) {
		// TODO Auto-generated method stub
			if(st==parents[st])
				return st;
			parents[st]=find(parents[st]);
			return parents[st];
	}

	private static void union(int st, int ed) {
		// TODO Auto-generated method stub
		parents[find(st)]=find(ed);
	}
}