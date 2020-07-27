import java.util.LinkedList;
import java.util.Queue;

public class first2020_4 {

	static class Point {
		int x, y;
		int cost;
		int v;

		public Point(int x, int y, int cost, int v) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.v = v;
		}

	}

	// À§ ¾Æ·¡ ¿À ¿Þ
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	
	static int result = Integer.MAX_VALUE;
	static boolean visited[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
//		int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},
//						{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
//		int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		int N = board.length;
		visited= new boolean[N][N];
		Point p = new Point(0,0,0,4);
		solve(board,N,p);
		System.out.println(result);
	}

	private static void solve(int[][] board, int n, Point p) {
		// TODO Auto-generated method stub
		if(p.x==n-1 &&p.y==n-1) {
			result = Math.min(result, p.cost);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = p.x+dx[i];
			int ny = p.y+dy[i];
			int ncost;
			if(nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;
			if(board[nx][ny]==1)
				continue;
			if(visited[nx][ny])
				continue;
			if(p.v==4) {
				ncost = p.cost + 100;
			}else {
				if( ( p.v < 2 && i>= 2 ) || ( p.v >= 2 && i<2 ))
					ncost = p.cost + 600;
				else {
					ncost = p.cost + 100;
				}
			}
			visited[nx][ny]=true;
			solve(board,n,new Point(nx,ny,ncost,i));
			visited[nx][ny]=false;
		}
	}

}
