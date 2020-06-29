public class test2 {
	public static void main(String[] args) {
		//�߽����κ��� ������ �� ������ �Ÿ�
		int[] target = {2, 2, 2, 2, 2};
		//�־��� ȭ�� 10���� ��ġ
		int[][] position = {{0, 0}, {0, 1}, {1, 1}, {-3, 5}, {7,5}, {10, 0}, {-15, 22}, {-6, -5}, {3, 3}, {5, -5}};
//		long start = System.currentTimeMillis();
		System.out.println(solution(target,position));
//		long end = System.currentTimeMillis();
//		System.out.println("����ð� : "+(end-start/1000.0));
	}
	
	public static int solution(int[] target, int[][] positions) {
        int answer = 0;
        //�־��� ������ �� �Ÿ��� ���������� �Ÿ��� ����
        for (int i = 1; i < 5; i++) {
			target[i]+=target[i-1];
		}
        //ȭ���� �Ÿ��� ���ϱ� ���� ������ ������ ����
//        for (int j = 0; j < 5; j++) {
//        	target[j]=target[j]*target[j];        	
//        }
        //��ǥ x,y�� �̿��Ͽ� �������� �Ÿ��� ���ؼ� ������ ��� ������ ���Ѵ� 
        for (int i = 0; i <10; i++) {
			int x=positions[i][0];
			int y=positions[i][1];
			double dist = Math.sqrt(x*x+y*y);
			answer+=get_score(target,dist);
		}
        
        return answer;
    }
	
	//��ǥ�� �Ÿ��� �� ������ �Ÿ��� ���Ͽ� ����å��
	private static int get_score(int[] target, double dist) {
		// TODO Auto-generated method stub
		if( dist<=target[0] )
			return 10;
		else if( dist<=target[1] )
			return 8;
		else if( dist<=target[2] )
			return 6;
		else if( dist<=target[3] )
			return 4;
		else if( dist<=target[4] )
			return 2;
		return 0;
	}

	
}
