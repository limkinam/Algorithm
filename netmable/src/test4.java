
public class test4 {
   public static void main(String[] args) {
      long start = System.currentTimeMillis();
      int n=100;
      System.out.println(Solution(n));
      long end = System.currentTimeMillis();
      System.out.println("실행시간 :"+(end-start/1000.0));
   }
   
   static long Solution(int n) {
	  // 각 n의 결과를 저장할 배열을 만든다.
      long arr[]= new long[n+1];
      // 배열 2,3은 유일하게 1*(n-1)이 최대이므로 defualt 입력
      arr[2]=2;
      arr[3]=3;
      // n은 4부터 실행
      for (int i = 4; i <= n; i++) {
         int mid = i/2;
//         mid를 기준으로 대칭이므로 중간까지만 본다.
         for (int j = 2; j <=mid ; j++) {
            arr[i]=Math.max(arr[i], arr[j]*arr[i-j]);
         }
      }
      return arr[n];
   }
}