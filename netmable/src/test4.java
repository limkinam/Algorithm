
public class test4 {
   public static void main(String[] args) {
      long start = System.currentTimeMillis();
      int n=100;
      System.out.println(Solution(n));
      long end = System.currentTimeMillis();
      System.out.println("����ð� :"+(end-start/1000.0));
   }
   
   static long Solution(int n) {
	  // �� n�� ����� ������ �迭�� �����.
      long arr[]= new long[n+1];
      // �迭 2,3�� �����ϰ� 1*(n-1)�� �ִ��̹Ƿ� defualt �Է�
      arr[2]=2;
      arr[3]=3;
      // n�� 4���� ����
      for (int i = 4; i <= n; i++) {
         int mid = i/2;
//         mid�� �������� ��Ī�̹Ƿ� �߰������� ����.
         for (int j = 2; j <=mid ; j++) {
            arr[i]=Math.max(arr[i], arr[j]*arr[i-j]);
         }
      }
      return arr[n];
   }
}