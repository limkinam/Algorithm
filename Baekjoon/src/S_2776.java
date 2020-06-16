import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_2776 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(stk.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			int arr2[] = new int[M];
			stk = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				arr2[j] = Integer.parseInt(stk.nextToken());
			}
			
			Arrays.sort(arr);
			
			for (int j = 0; j < M; j++) {
				if(BinarySearch(arr,arr2[j])){
					arr2[j]=1;
				}
				else {
					arr2[j]=0;
				}
			}		
			for (int j = 0; j < M; j++) {
				System.out.println(arr2[j]);
			}
		}
	}

	private static boolean BinarySearch(int[] arr, int i) {
		// TODO Auto-generated method stub
		
		int st = 0;
		int ed = arr.length - 1;
		
		while(true) {
			int ct = (st + ed) / 2;
			if(arr[ct] == i) 
				return true;
			else if(arr[ct] < i)
				st = ct + 1;
			else {
				ed = ct - 1;
			}
			
			if(st>ed)
				break;
			
		}
		return false;
	}

}
