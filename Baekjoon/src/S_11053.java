import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_11053 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int arr[] = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(stk.nextToken());
		}
		
		int dp[]= new int[N];
		
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			dp[i]=1;
			for (int j = 0; j < i; j++) {
				
				if(arr[j] < arr[i] && dp[j] >= dp[i]) {
					
					dp[i] = dp[j] + 1;
					
				}
				
			}
			
			if(dp[i] > result) result=dp[i] ;
			
		}
		
				
		System.out.println(result);
		
	}

}

//6
//10 20 10 30 20 50