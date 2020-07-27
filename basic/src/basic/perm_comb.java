package basic;

import java.util.Arrays;

public class perm_comb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5};
		int N = arr.length;
		int K = 3;
		//�κ�����
		power(arr,0,new boolean[N]);
		//����
//		com(arr,0,0,new int[K]);
		//�ߺ�����
//		re_com(arr,0,0,new int[K]);
		//����
//		perm(arr,0,new int[K],new boolean[N]);
		//�ߺ� ����
//		re_perm(arr,0,new int[K]);
	}
	
	private static void power(int[] arr, int i, boolean[] bs) {
		// TODO Auto-generated method stub
		if(i==arr.length) {
			for (int j = 0; j < arr.length; j++) {
				if(bs[j])
					System.out.print(arr[j]);
			}
			System.out.println();
			return;
		}
		bs[i]=false;
		power(arr,i+1,bs);
		bs[i]=true;
		power(arr,i+1,bs);
		
		
	}

	private static void re_com(int[] arr, int i, int j, int[] rs) {
		// TODO Auto-generated method stub
		if(j==rs.length) {
			System.out.println(Arrays.toString(rs));
			return;
		}
		if(i==arr.length)
			return;
		
		rs[j]=arr[i];
		re_com(arr,i,j+1,rs);
		re_com(arr,i+1,j,rs);
		
	}

	private static void com(int[] arr, int i, int j, int[] rs) {
		// TODO Auto-generated method stub
		if(j==rs.length) {
			System.out.println(Arrays.toString(rs));
			return;
		}
		if(i==arr.length)
			return;
		
		rs[j]=arr[i];
		com(arr,i+1,j+1,rs);
		com(arr,i+1,j,rs);
		
		
	}

	//����
	private static void perm(int[] arr, int i, int[] rs, boolean[] visited) {
		// TODO Auto-generated method stub
		if(i==rs.length) {
			System.out.println(Arrays.toString(rs));
			return;
		}
		for (int j = 0; j < arr.length; j++) {
			if(visited[j])
				continue;
			rs[i]=arr[j];
			visited[j]=true;
			perm(arr,i+1,rs,visited);
			visited[j]=false;
			
		}
		
	}


	//�O������
	private static void re_perm(int[] arr, int i, int[] rs) {
		// TODO Auto-generated method stub
		if(i==rs.length) {
			System.out.println(Arrays.toString(rs));
			return;
		}
		
		for (int j = 0; j < arr.length; j++) {
			rs[i]=arr[j];
			re_perm(arr,i+1,rs);
		}
		
	}
	
	
	
}
