import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2 1 5

public class S_2869 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk  = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(stk.nextToken());
		int B = Integer.parseInt(stk.nextToken());
		int V = Integer.parseInt(stk.nextToken());
		
		
		int result = (V-A) / (A-B);
		
		if((V-A) % (A-B) !=0) result += 1;
		
		
		result += 1;
		System.out.println(result);
		
	}

}
