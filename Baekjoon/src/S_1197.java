import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S_1197 {

	static class Vertex implements Comparable<Vertex>{
		int v,val;

		public Vertex(int v, int val) {
			super();
			this.v = v;
			this.val = val;
		}

		@Override
		public int compareTo(Vertex v) {
			// TODO Auto-generated method stub
			return this.val-v.val;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(stk.nextToken());
		int E = Integer.parseInt(stk.nextToken());
		
		ArrayList<Vertex>[] arr = new ArrayList[V];
		
		for (int i = 0; i < V; i++) {
			arr[i]=new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(stk.nextToken())-1;
			int B = Integer.parseInt(stk.nextToken())-1;
			int C = Integer.parseInt(stk.nextToken());
			arr[A].add(new Vertex(B, C));
			arr[B].add(new Vertex(A, C));
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.addAll(arr[0]);
		boolean[] visited = new boolean[V];
		visited[0]=true;
		
		int result = 0;
		
		for (int i = 0; i < V-1; i++) {
			while(true) {
				Vertex tmp = pq.poll();
				if(visited[tmp.v])
					continue;
				visited[tmp.v]=true;
				result+=tmp.val;
				pq.addAll(arr[tmp.v]);
				break;
			}
		}
		
		System.out.println(result);
	}

}
