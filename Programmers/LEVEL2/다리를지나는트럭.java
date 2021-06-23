import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        q.offer(truck_weights[0]);// 첫번째꺼 무조건 넣기
        answer++;//1초 증가
        int total = q.peek();
        
        int idx = 1;
        while(true){
            
            if(idx == truck_weights.length){
                answer+= bridge_length;
                break;// 마지막이라면 종료
            }
              
            if(q.size()==bridge_length){// 사이즈 다차면
                int p = q.poll();
                total-=p;// 빼준다
                
            }
            
            if(idx < truck_weights.length &&(total+truck_weights[idx])<=weight){
                    total+=truck_weights[idx];// 무게 넣어주고
                    q.offer(truck_weights[idx]);// 큐에다가도 넣어줌
                    answer++;
                    idx++;
                    continue;
            }
            
            q.offer(0);
            answer++;
            
        }  // end of while
        
        return answer;
    }
}// end of class
