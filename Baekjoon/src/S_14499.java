import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_14499 {
	
	//�ֻ��� �� ��
	static class Dice{
		int state;
		int value;
		public Dice(int state) {
			super();
			this.state = state;
		}
		@Override
		public String toString() {
			return "Dice [state=" + state + ", value=" + value + "]";
		}
		
		
		
	}
	static int N,M;
	static int arr[][];
	static int x,y;
	static Dice dice[];
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		y = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		
		arr= new int[N][M];
		//�����׸���
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		//�ֻ��� ����
		dice=new Dice[6];
		for (int i = 0; i < 6; i++) {
			dice[i] = new Dice(i);
		}
		
		stk = new StringTokenizer(br.readLine());
		int command=0;
		for (int i = 0; i < K; i++) {
//			System.out.println(Arrays.toString(dice));
			command = Integer.parseInt(stk.nextToken());
			switch(command) {
			case 1:
				move1();
				break;
			case 2:
				move2();
				break;
			case 3:
				move3();
				break;
			case 4:
				move4();
				break;
			}
		}
		
	}

	//����
	private static void move1() {
		// TODO Auto-generated method stub
		if(y==M-1)
			return;
		y+=1;
		for (int i = 0; i < 6; i++) {
			switch(dice[i].state) {
			case 0:
				dice[i].state = 2;
			break;
			case 1:
				dice[i].state = 3;
				break;
			case 2:
				dice[i].state = 1;
				System.out.println(dice[i].value);
				break;
			case 3:
				dice[i].state = 0;
				if(arr[x][y]==0) {
					arr[x][y]=dice[i].value;
				}else {
					dice[i].value=arr[x][y];
					arr[x][y]=0;
				}
				break;
			case 4:
				dice[i].state = 4;
				break;
			case 5:
				dice[i].state = 5;
				break;
			}
		}
	}

	//����
	private static void move2() {
		// TODO Auto-generated method stub
		if(y==0)
			return;
		y-=1;
		for (int i = 0; i < 6; i++) {
			switch(dice[i].state) {
			case 0:
				dice[i].state = 3;
			break;
			case 1:
				dice[i].state = 2;
				break;
			case 2:
				dice[i].state = 0;
				if(arr[x][y]==0) {
					arr[x][y]=dice[i].value;
				}else {
					dice[i].value=arr[x][y];
					arr[x][y]=0;
				}
				break;
			case 3:
				dice[i].state = 1;
				System.out.println(dice[i].value);
				break;
			case 4:
				dice[i].state = 4;
				break;
			case 5:
				dice[i].state = 5;
				break;
			}
		}

	}

	//����
	private static void move3() {
		// TODO Auto-generated method stub
		if(x==0)
			return;
		x-=1;
		for (int i = 0; i < 6; i++) {
			switch(dice[i].state) {
			case 0:
				dice[i].state = 5;
			break;
			case 1:
				dice[i].state = 4;
				break;
			case 2:
				dice[i].state = 2;
				break;
			case 3:
				dice[i].state = 3;
				break;
			case 4:
				dice[i].state = 0;
				if(arr[x][y]==0) {
					arr[x][y]=dice[i].value;
				}else {
					dice[i].value=arr[x][y];
					arr[x][y]=0;
				}
				break;
			case 5:
				dice[i].state = 1;
				System.out.println(dice[i].value);
				break;
			}
		}
	}

	//����
	private static void move4() {
		// TODO Auto-generated method stub
		if(x==N-1)
			return;
		x+=1;
		for (int i = 0; i < 6; i++) {
			switch(dice[i].state) {
			case 0:
				dice[i].state = 4;
			break;
			case 1:
				dice[i].state = 5;
				break;
			case 2:
				dice[i].state = 2;
				break;
			case 3:
				dice[i].state = 3;
				break;
			case 4:
				dice[i].state = 1;
				System.out.println(dice[i].value);
				break;
			case 5:
				dice[i].state = 0;
				if(arr[x][y]==0) {
					arr[x][y]=dice[i].value;
				}else {
					dice[i].value=arr[x][y];
					arr[x][y]=0;
				}
				break;
			}
		}
	}
}
