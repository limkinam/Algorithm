import java.util.LinkedList;
import java.util.Queue;

public class test3 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String[] board = {"EEEEE","EEMEE","EEEEE", "EEEEE"};
		int y=2;
		int x=0;
		
		
		String[] answer = solution(board,y,x);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		long end = System.currentTimeMillis();
		System.out.println("����ð� : "+ (end-start/1000.0));
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
	//8����
	static int dy[] = { 0, 0, 1, 1, 1, -1, -1, -1 };
	static int dx[] = { 1, -1, 1, 0, -1, 1, 0, -1 };

	private static String[] solution(String[] board, int y, int x) {// �� ��

		int N = board.length;
		int M = board[0].length();
		String[] answer=new String[N];
		char arr[][] = new char[N][M];
		boolean flag = true;
		//�־��� ������ �׸���
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = board[i].charAt(j);
			}
		}
		//BFS�� ���� ť ���
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		q.add(new Point(y, x));
		visited[y][x] = true;
		

		//���� ��ġ�� ���ڸ� �ش� ���� X�� �ٲ��ش�
		if (arr[y][x] == 'M') {
			flag = false;
			arr[y][x] = 'X';
		//���� ��ġ�� ���ڰ� �ƴҽ� BFS ����
		} else {

			while (!q.isEmpty()) {
				Point temp = q.poll();
				int cnt = 0;
				int ny;
				int nx;
				for (int i = 0; i < 8; i++) {
					ny = temp.y + dy[i];
					nx = temp.x + dx[i];

					if (ny < 0 || ny >= N || nx < 0 || nx >= M)
						continue;
					if (visited[ny][nx])
						continue;
					//�� ���⿡ ������ ������ ����
					if (arr[ny][nx] == 'M')
						cnt++;
				}
				//������ ������ �ش� ��ġ�� �����ش�.
				arr[temp.y][temp.x] = (char) (cnt+'0');
				//8���� ��� ���ڰ� ������ B�� �����ְ� ��� ������ ť�� �־��ش�.
				if (cnt == 0) {
					arr[temp.y][temp.x]='B';
					for (int i = 0; i < 8; i++) {
						ny = temp.y + dy[i];
						nx = temp.x + dx[i];

						if (ny < 0 || ny >= N || nx < 0 || nx >= M)
							continue;
						if (visited[ny][nx])
							continue;
						q.add(new Point(ny,nx));
						visited[ny][nx]=true;
					}
				}
				
			}
		}
		// ��� �ڷ����� �°� �����Ѵ�.
		for (int i = 0; i < N; i++) {
			String tmp ="";
			for (int j = 0; j < M; j++) {
				// ���ڸ� ������ ���� ���  ��½� ���ڸ� E�� ����Ѵ�.
				if(arr[i][j]=='M' && flag)
					arr[i][j]='E';
				tmp+=arr[i][j];
			}
			answer[i]=tmp;
		}
		

		return answer;
	}
}
