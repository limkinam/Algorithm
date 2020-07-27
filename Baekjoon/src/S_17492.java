import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_17492 {
   
   static int N;
   static boolean b;
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      N = Integer.parseInt(br.readLine());
      int cnt=0;
      int arr[][] = new int[N][N];
      StringTokenizer stk;
      for (int i = 0; i < N; i++) {
         stk = new StringTokenizer(br.readLine());
         for (int j = 0; j < N; j++) {
            arr[i][j]=Integer.parseInt(stk.nextToken());
            if(arr[i][j]==2)
               cnt++;
         }
      }
      //주어진 입력과 바둑알의 갯수를 인자로 입력받는다.
      dfs(arr,cnt);
      
      if(b)
         System.out.println("Possible");
      else
         System.out.println("Impossible");
      
   }
   
   static int dx[] = {0,0,1,1,1,-1,-1,-1};
   static int dy[] = {1,-1,0,1,-1,0,1,-1};
   

   private static void dfs(int[][] arr,int cnt) {
      // TODO Auto-generated method stub
      //바둑알이 하나 남은경우는 가능한 경우이므로 재귀를 끝낸다. 
      if(cnt==1) {
         b=true;
         return;
      }
      //모든 경우를 탐색
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
        	 //바둑알일 경우
            if(arr[i][j]==2) {
            	//8방향 탐색한다.
               for (int k = 0; k < 8; k++) {
            	  //한칸과 두칸의 값을 판별한다.
                  int nx1 = i+dx[k];
                  int nx2 = nx1+dx[k];
                  int ny1 = j+dy[k];
                  int ny2 = ny1+dy[k];
                  if(nx1<0 || nx1>=N || ny1<0 || ny1>=N)
                     continue;
                  if(nx2<0 || nx2>=N || ny2<0 || ny2>=N)
                     continue;
                  if(arr[nx1][ny1]!=2 || arr[nx2][ny2]!=0)
                     continue;
                  //바둑알이 움직일 수 있는경우 게임 규칙을 적용하여 값을 바꿔준다.
                  arr[nx1][ny1]=0;
                  arr[i][j]=0;
                  arr[nx2][ny2]=2;
                  //현재 상태와 바둑알의 갯수를 넘겨준다
                  dfs(arr,cnt-1);
                  //백트래킹을 위해 원상태로 복구시킨다.
                  arr[nx1][ny1]=2;
                  arr[i][j]=2;
                  arr[nx2][ny2]=0;
               }
            }
         }
      }
      
   }

}