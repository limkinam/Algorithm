public class test2 {
	public static void main(String[] args) {
		//중심으로부터 과녁의 각 점수별 거리
		int[] target = {2, 2, 2, 2, 2};
		//주어진 화살 10개의 위치
		int[][] position = {{0, 0}, {0, 1}, {1, 1}, {-3, 5}, {7,5}, {10, 0}, {-15, 22}, {-6, -5}, {3, 3}, {5, -5}};
//		long start = System.currentTimeMillis();
		System.out.println(solution(target,position));
//		long end = System.currentTimeMillis();
//		System.out.println("실행시간 : "+(end-start/1000.0));
	}
	
	public static int solution(int[] target, int[][] positions) {
        int answer = 0;
        //주어진 과녁의 각 거리를 원점에서의 거리로 수정
        for (int i = 1; i < 5; i++) {
			target[i]+=target[i-1];
		}
        //화살의 거리와 비교하기 위해 제곱의 값으로 수정
//        for (int j = 0; j < 5; j++) {
//        	target[j]=target[j]*target[j];        	
//        }
        //좌표 x,y를 이용하여 원점에서 거리를 구해서 점수를 얻어 총점에 더한다 
        for (int i = 0; i <10; i++) {
			int x=positions[i][0];
			int y=positions[i][1];
			double dist = Math.sqrt(x*x+y*y);
			answer+=get_score(target,dist);
		}
        
        return answer;
    }
	
	//좌표의 거리와 각 점수별 거리를 비교하여 점수책정
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
