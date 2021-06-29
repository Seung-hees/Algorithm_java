import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 입력
        for(int i=0; i<scoville.length;i++){
            pq.add(scoville[i]);
        }
    
        while(pq.peek()<=K){
            if(pq.size() == 1){
                answer = -1;
                break;
            }
            int a = pq.poll();// 첫번째
            int b = pq.poll();// 두번째
            
            int n = a + b*2;
            answer++;
            pq.offer(n);
            

        }

        return answer;
    }
}
