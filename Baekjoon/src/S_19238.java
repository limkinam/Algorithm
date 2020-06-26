import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_19238 {

	static class Taxi {
		int x;
		int y;
		int fuel;

		public Taxi(int x, int y, int fuel) {
			super();
			this.x = x;
			this.y = y;
			this.fuel = fuel;
		}

		@Override
		public String toString() {
			return "Taxi [x=" + x + ", y=" + y + ", fuel=" + fuel + "]";
		}
		
		
	}

	static class Passenger {
		int x, y, edx, edy;
		boolean visited;

		public Passenger(int x, int y, int edx, int edy) {
			super();
			this.x = x;
			this.y = y;
			this.edx = edx;
			this.edy = edy;
		}

		@Override
		public String toString() {
			return "Passenger [x=" + x + ", y=" + y + ", edx=" + edx + ", edy=" + edy + ", visited=" + visited + "]";
		}
		
		

	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int fuel = Integer.parseInt(stk.nextToken());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		stk = new StringTokenizer(br.readLine());
		Taxi taxi = new Taxi(Integer.parseInt(stk.nextToken())-1, Integer.parseInt(stk.nextToken())-1, fuel);
		Passenger[] pas = new Passenger[M];

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());

			pas[i] = new Passenger(Integer.parseInt(stk.nextToken())-1, Integer.parseInt(stk.nextToken())-1,
					Integer.parseInt(stk.nextToken())-1, Integer.parseInt(stk.nextToken())-1);
		}
		int Mcnt=M;
		int result = -1;
		
		
		
		loop: while (true) {
			//처음 시작점이에 승객있는지 확인
			int b=987654321;
			for (int i = 0; i < Mcnt; i++) {
				if(taxi.x==pas[i].x && taxi.y==pas[i].y && !pas[i].visited) {
					b=i;
				}
			}
			//제자리
			// 선택하는거
			Queue<Taxi> q = new LinkedList<Taxi>();
			q.add(taxi);
			boolean[][] visited = new boolean[N][N];
			visited[taxi.x][taxi.y] = true;
			Passenger ptmp = null;
			if(b==987654321) {
			loop2: while (true) {
				if(q.isEmpty()) {
					break loop;
				}
				int cnt = q.size();
				for (int i = 0; i < cnt; i++) {
					Taxi tmp = q.poll();
					if (tmp.fuel == 0) {
						break loop;
					}
					boolean flag = false;// 승객을 찾았는지
					for (int j = 0; j < 4; j++) {
						int nx = tmp.x + dx[j];
						int ny = tmp.y + dy[j];

						if (nx < 0 || nx >= N || ny < 0 || ny >= N)
							continue;
						if (arr[nx][ny] == 1)
							continue;
						if (visited[nx][ny])
							continue;

						for (int k = 0; k < Mcnt; k++) {
							if (pas[k].x == nx && pas[k].y == ny && !pas[k].visited) {
								flag = true;
								fuel = tmp.fuel-1;
								if (ptmp == null) {
									ptmp = pas[k];
									pas[k].visited = true;
								} else {
									if (ptmp.x > pas[k].x) {
										ptmp.visited = false;
										pas[k].visited = true;
										ptmp = pas[k];
									} else if (ptmp.x == pas[k].x) {
										if (ptmp.y > pas[k].y) {
											ptmp.visited = false;
											pas[k].visited = true;
											ptmp = pas[k];
										}
									}
								}
							}
						}
						visited[nx][ny] = true;
						q.add(new Taxi(nx, ny, tmp.fuel - 1));
					}
					if (flag)
						break loop2;
				}

			}
			}else {
				ptmp = pas[b];
				pas[b].visited=true;
				b=987654321;
			}
			taxi = new Taxi(ptmp.x, ptmp.y, fuel);
			visited = new boolean[N][N];
			visited[taxi.x][taxi.y] = true;
			Queue<Taxi> q2 = new LinkedList<Taxi>();
			q2.add(taxi);
			int dist=0;
			loop3: while (true) {
				if(q2.isEmpty()) {
					break loop;
				}
				int cnt = q2.size();
				dist++;
				for (int i = 0; i < cnt; i++) {
					Taxi tmp = q2.poll();
					if (tmp.fuel == 0) {
						break loop;
					}
					
					for (int j = 0; j < 4; j++) {
						int nx = tmp.x + dx[j];
						int ny = tmp.y + dy[j];

						if (nx < 0 || nx >= N || ny < 0 || ny >= N)
							continue;
						if (arr[nx][ny] == 1)
							continue;
						if (visited[nx][ny])
							continue;
						if (nx == ptmp.edx && ny == ptmp.edy) {
							M--;
							tmp.fuel-=1;
							tmp.fuel+=dist*2;						
							taxi = new Taxi(nx, ny,tmp.fuel);
							fuel=tmp.fuel;
							break loop3;
						}
						visited[nx][ny] = true;
						q2.add(new Taxi(nx, ny, tmp.fuel - 1));
					}
				}
			}
			if (M == 0) {
				result=taxi.fuel;
						break;
			}

		}
		
		System.out.println(result);
	}

}
