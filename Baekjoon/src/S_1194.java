import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_1194 {
	
	static class Point{
		int x,y;
		int cnt,key;
		public Point(int x, int y, int cnt, int key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
		
		
		
		
	}
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken()); // 세로
		int M = Integer.parseInt(stk.nextToken()); // 가로
		
		Point sp = null;
		Point ep = null;
		
		Queue<Point> q = new LinkedList<>();
		
		char arr[][] = new char[N][M];
		boolean visited[][][] = new boolean[64][N][M];
		
		for ( int i = 0; i < N; i++ ) {
			String s = br.readLine();
			
			for ( int j = 0; j < M; j++ ) {
				arr[i][j] = s.charAt(j);
				if( arr[i][j] == '0' ) {
					sp = new Point(i,j,0,0); // 시작
				}
			}
		}
		
		q.add(sp);
		visited[0][sp.x][sp.y]=true;
		
		int result = -1;
		
		loop:while(!q.isEmpty()) {
			Point tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				int key=tmp.key;
				
				if(nx < 0 || nx >=N || ny < 0 || ny >=M)
					continue;
				if(arr[nx][ny]=='#')
					continue;
				if(arr[nx][ny]=='1') {
					result = tmp.cnt+1;
					break loop;
				}
				if(visited[tmp.key][nx][ny])
					continue;
				if(arr[nx][ny]>='a' && arr[nx][ny]<='f') {
					if((key & (1 << (arr[nx][ny]-'a'))) != (1 << (arr[nx][ny]-'a')))//키를 처음 얻으면
						key += 1 << (arr[nx][ny]-'a');
					visited[key][nx][ny]=true;
					q.add(new Point(nx,ny,tmp.cnt+1,key));
				}else if(arr[nx][ny]>='A' && arr[nx][ny]<='F'){
					if((key & (1 << (arr[nx][ny]-'A'))) != (1 << (arr[nx][ny]-'A')))//열수 있는 키가 없으면
						continue;
					visited[key][nx][ny]=true;
					q.add(new Point(nx,ny,tmp.cnt+1,key));
				}
				visited[key][nx][ny]=true;
				q.add(new Point(nx,ny,tmp.cnt+1,key));
			}
		}
		
		System.out.println(result);
		
	}

}

