
public class first2020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		�׽�Ʈ ���̽� 1
//		int num[] = {1,3,4,5,8,2,1,4,5,9,5};
//		String hand = "right";
		
//		�׽�Ʈ ���̽� 2
//		int num[] = {7,0,8,2,8,3,1,5,7,6,2};
//		String hand = "left";
		
//		�׽�Ʈ ���̽� 3
		int num[] = {1,2,3,4,5,6,7,8,9,0};
		String hand = "right";
		
		String result="";
		
//		���ο� ���� �Ÿ� �׷����� �����
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
		
//		�μ��� ��ġ {��,����} �ʱⰪ �迭�� ���ٸ��ϴ� *10 # 11���� ����
		int hand_state[]= {10,11};
		
		for (int i = 0; i < num.length; i++) {
			System.out.println(hand_state[0]+" "+hand_state[1]);
//			������ �޼�
			if(num[i]==1 || num[i]==4 || num[i]==7) {
				hand_state[0]=num[i];
				result+="L";
			}
//			������ ������
			else if(num[i]==3 || num[i]==6 || num[i]==9) {
				hand_state[1]=num[i];
				result+="R";
			}
			
			else {
				
				int Left_distance = distance[hand_state[0]][num[i]];
				int Right_distance = distance[hand_state[1]][num[i]];
				//�޼��� �� ������
				if(Left_distance < Right_distance) {
					
					hand_state[0]=num[i];
					result+="L";
					
				}
				//�������� �� ������
				else if(Left_distance > Right_distance) {
					
					hand_state[1]=num[i];
					result+="R";
					
				}
				//������ ������ ����
				else {
					//�޼����̸�
					if(hand.equals("left")) {
						
						hand_state[0]=num[i];
						result+="L";
						
					}
					//���������̸�
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
