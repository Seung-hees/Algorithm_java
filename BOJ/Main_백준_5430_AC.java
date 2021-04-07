import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
// 옮기지 않고 방향만을 바꿔준다. 
public class Main_백준_5430_AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Deque<Integer> dq = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < TC; i++) {
			String str = br.readLine();// RDD
			int N = Integer.parseInt(br.readLine());// 숫자
			
			StringTokenizer st = new StringTokenizer(br.readLine(),"[,]");

			for (int j = 0; j < N; j++) {
				dq.addLast(Integer.parseInt(st.nextToken()));
			}
			
			boolean reverse = false;// 정방향
			boolean check = true;
			
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == 'R') {// 뒤집기
					reverse = !reverse;
				}else {//D 버리기
					if(dq.isEmpty()) {
						check = false;
					}else if(!reverse) {// false 정방향
						dq.pollFirst();
					}else if(reverse) {// true 반대방향
						dq.pollLast();
					}
				}
				
			}
			
			if(!check) {
				sb.append("error").append("\n");
			}else {				
				int size = dq.size();
				sb.append("[");
				if(size>0) {
					for (int j = 0; j < size; j++) {
						if(reverse) {
							sb.append(dq.pollLast()).append(",");
						}else {
							sb.append(dq.pollFirst()).append(",");						
						}
					}
					sb.deleteCharAt(sb.lastIndexOf(","));
					
				}
				sb.append("]").append("\n");
			}
			

		}//end of tc
		
		System.out.println(sb.toString());
		
	}// end of main
}// end of class
