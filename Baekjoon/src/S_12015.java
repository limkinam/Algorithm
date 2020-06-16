import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_12015 {

	//6
	//10 20 10 30 20 50
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int arr[] = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(stk.nextToken());
		}
		
		int dp[] = new int[N];
		
		int idx = 0;
		
		dp[idx]=arr[0];
		
		for (int i = 1; i < N; i++) {
			if(dp[idx] < arr[i] ) {
				idx++;
				dp[idx]=arr[i];
			}
			else {
				dp[lowerBound(dp,idx,arr[i])]=arr[i];
			}
		}
		
		System.out.println(idx+1);
		
	}

	private static int lowerBound(int[] dp, int idx, int i) {
		// TODO Auto-generated method stub
		int st = 0;
		int ed = idx;
		while(true) {
			int ct = (st + ed) / 2;
			if(dp[ct] < i)
				st = ct + 1;
			else {
				ed = ct;
			}
			if(st>=ed)
				break;
			
		}
		return st;
	}

}
