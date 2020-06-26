import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S_1753 {
	
	static class Edge{
		int v,val;

		public Edge(int v, int val) {
			super();
			this.v = v;
			this.val = val;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(stk.nextToken());
		int E = Integer.parseInt(stk.nextToken());
		int st = Integer.parseInt(br.readLine());
		
		ArrayList<Edge>[] list = new ArrayList[V+1];
		
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<Edge>();
		}
		
		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine());
			int vs = Integer.parseInt(stk.nextToken());
			int es = Integer.parseInt(stk.nextToken());
			int val = Integer.parseInt(stk.nextToken());
			boolean b = true;
			for (int j = 0; j < list[vs].size(); j++) {
				if(es == list[vs].get(j).v) {
					b=false;
					list[vs].get(j).val = Math.min(val, list[vs].get(j).val);
					break;
				}
			}
			
			if(b) {
				list[vs].add(new Edge(es,val));
			}
			
		}
		
		int[] dist = new int[V+1];
		boolean visited[]= new boolean[V+1];
		for (int i = 1; i <= V; i++) {
			dist[i]=987654321;
		}
		
		dist[st]=0;
		visited[st]=true;
		
		for (int i = 0; i < list[st].size(); i++) {
			dist[list[st].get(i).v]=list[st].get(i).val;
		}
		
		for (int i = 1; i <= V-1; i++) {
			int idx=st;
			int min = 987654321;
			for (int j = 1; j <= V; j++) {
				if(!visited[j] && dist[j]<min) {
					idx=j;
					min=dist[j];
				}
			}
			visited[idx]=true;
			for (int j = 0; j < list[idx].size(); j++) {
				dist[list[idx].get(j).v]=Math.min(dist[list[idx].get(j).v],dist[idx]+list[idx].get(j).val);
			}
			
		}
		
		for (int i = 1; i <= V; i++) {
			if(dist[i]==987654321)
				System.out.println("INF");
			else 
				System.out.println(dist[i]);
		}
		
		
	}

}


//5 6
//1
//5 1 1
//1 2 2
//1 3 3
//2 3 4
//2 4 5
//3 4 6