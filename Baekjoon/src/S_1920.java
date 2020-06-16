import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		5
//		4 1 5 2 3
//		5
//		1 3 7 9 5

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		int arr2[] = new int[M];
		for (int i = 0; i <M; i++) {
			arr2[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(arr);
		for (int i = 0; i < M; i++) {
			boolean flag = BinarySearch(arr,arr2[i]);
			if(flag) {
				arr2[i]=1;
			} else {
				arr2[i]=0;
			}
		}
		
		
		for (int i = 0; i < M; i++) {
			System.out.println(arr2[i]);
		}
		
	}

	private static boolean BinarySearch(int[] arr, int i) {
		// TODO Auto-generated method stub
		
		int st = 0;
		int ed = arr.length-1;
		while(true) {
			int ct = (st + ed) / 2;
			if(arr[ct] == i)
				return true;
			else if(arr[ct] < i)
				st = ct + 1;
			else {
				ed = ct-1;
			}	
			if(st > ed)
				break;
		}
		return false;
	}

}
