import java.util.Scanner;
import java.util.stream.IntStream;
class Solution {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스 10회
		for (int tc = 1; tc <= 10; tc++) {
			int L = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			
			// 4종류의 괄호문자들 생성
			int[] arr = new int[4];
			
			for (int i = 0; i < str.length(); i++) {
				
				//switch 문으로 바꾸기
				if(str.charAt(i)=='(') {
					arr[0]++;
				}
				else if(str.charAt(i)==')') {
					arr[0]--;
				}
				else if(str.charAt(i)=='[') {
					arr[1]++;
				}
				else if(str.charAt(i)==']') {
					arr[1]--;
				}
				else if(str.charAt(i)=='{') {
					arr[2]++;
				}
				else if(str.charAt(i)=='}') {
					arr[2]--;
				}
				else if(str.charAt(i)=='<') {
					arr[3]++;
				}
				else if(str.charAt(i)=='>') {
					arr[3]--;
				}
			}
			// 1- 유효함 ,0- 유효하지 않음
		if(IntStream.of(arr).anyMatch(x->x!=0)) {
			System.out.println("#"+tc+" "+0);
		}
		else {
			System.out.println("#"+tc+" "+1);
		}
	
		}
		
	}//end of main
}//end of class
