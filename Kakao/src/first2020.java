
public class first2020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		테스트 케이스 1
//		int num[] = {1,3,4,5,8,2,1,4,5,9,5};
//		String hand = "right";
		
//		테스트 케이스 2
//		int num[] = {7,0,8,2,8,3,1,5,7,6,2};
//		String hand = "left";
		
//		테스트 케이스 3
		int num[] = {1,2,3,4,5,6,7,8,9,0};
		String hand = "right";
		
		String result="";
		
//		서로에 대한 거리 그래프를 만든다
		int distance[][] = {{0,4,3,4,3,2,3,2,1,2,1,1}
							,{4,0,1,2,1,2,3,2,3,4,3,5}
							,{3,1,0,1,2,1,2,3,2,3,4,4}
							,{4,2,1,0,3,2,1,4,3,2,5,3}
							,{3,1,2,3,0,1,2,1,2,3,2,4}
							,{2,2,1,2,1,0,1,2,1,2,3,3}
							,{3,3,2,1,2,1,0,3,2,1,4,2}
							,{2,2,3,4,1,2,3,0,1,2,1,3}
							,{1,3,2,3,2,1,2,1,0,1,2,2}
							,{2,4,3,2,3,2,1,2,1,0,3,1}
							,{1,3,4,5,2,3,4,1,2,3,0,0}
							,{1,5,4,3,4,3,2,3,2,1,0,0}};
		
//		두손의 위치 {왼,오른} 초기값 배열에 접근못하는 *10 # 11으로 설정
		int hand_state[]= {10,11};
		
		for (int i = 0; i < num.length; i++) {
			System.out.println(hand_state[0]+" "+hand_state[1]);
//			무조건 왼손
			if(num[i]==1 || num[i]==4 || num[i]==7) {
				hand_state[0]=num[i];
				result+="L";
			}
//			무조건 오른손
			else if(num[i]==3 || num[i]==6 || num[i]==9) {
				hand_state[1]=num[i];
				result+="R";
			}
			
			else {
				
				int Left_distance = distance[hand_state[0]][num[i]];
				int Right_distance = distance[hand_state[1]][num[i]];
				//왼손이 더 가까우면
				if(Left_distance < Right_distance) {
					
					hand_state[0]=num[i];
					result+="L";
					
				}
				//오른손이 더 가까우면
				else if(Left_distance > Right_distance) {
					
					hand_state[1]=num[i];
					result+="R";
					
				}
				//같으면 손잡이 구분
				else {
					//왼손잡이면
					if(hand.equals("left")) {
						
						hand_state[0]=num[i];
						result+="L";
						
					}
					//오른손잡이면
					else {
						
						hand_state[1]=num[i];
						result+="R";
						
					}
					
					
				}
				
			}
			
			
		}
		
		System.out.println(result);
	}

}
