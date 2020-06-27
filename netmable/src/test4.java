
public class test4 {
	public static void main(String[] args) {
		int n=2;
		System.out.println(Solution(n));
	}
	
	static long Solution(int n) {
		if(n==2)
	        return 1;
	    if(n==3)
	        return 2;
	    long [] arr = new long [n+1];
	    arr[0] = 1;
	    arr[1] = 1;
	    for (int i = 3; i <= n; i++) {
	        int i2 = i-2;
	        for (int j = 0; j <= i2; j++)
	            arr[i] = Math.max(arr[i], arr[j]*(i-j));
	    }
	    return arr[n];
	}
}
