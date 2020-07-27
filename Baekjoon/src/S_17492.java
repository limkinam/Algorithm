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
      //�־��� �Է°� �ٵϾ��� ������ ���ڷ� �Է¹޴´�.
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
      //�ٵϾ��� �ϳ� �������� ������ ����̹Ƿ� ��͸� ������. 
      if(cnt==1) {
         b=true;
         return;
      }
      //��� ��츦 Ž��
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
        	 //�ٵϾ��� ���
            if(arr[i][j]==2) {
            	//8���� Ž���Ѵ�.
               for (int k = 0; k < 8; k++) {
            	  //��ĭ�� ��ĭ�� ���� �Ǻ��Ѵ�.
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
                  //�ٵϾ��� ������ �� �ִ°�� ���� ��Ģ�� �����Ͽ� ���� �ٲ��ش�.
                  arr[nx1][ny1]=0;
                  arr[i][j]=0;
                  arr[nx2][ny2]=2;
                  //���� ���¿� �ٵϾ��� ������ �Ѱ��ش�
                  dfs(arr,cnt-1);
                  //��Ʈ��ŷ�� ���� �����·� ������Ų��.
                  arr[nx1][ny1]=2;
                  arr[i][j]=2;
                  arr[nx2][ny2]=0;
               }
            }
         }
      }
      
   }

}