import java.util.*;

class Solution {
    
    static class print {
        
        private int idx; // 인덱스
        private int imp;// 중요도
        
        public print(int idx, int imp){
            this.idx = idx;
            this.imp = imp;
        }
        
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<print> q = new LinkedList<print>();
        
        for(int i = 0; i <priorities.length; i++){
            q.offer(new print(i,priorities[i]));
        }
        
        while(!q.isEmpty()){
            
            boolean flag = false;
            int top = q.peek().imp;
            
            for(print p : q){
                if(p.imp > top){// 맨앞의 수보다 큰것이 존재
                    flag = true;
                    break;
                }
            }
            
            if(flag){
                q.offer(q.poll());
            }else{// 현재 맨앞의 숫자가 가장 클 때
                // 계속 빼면서 확인
                if(q.poll().idx == location){
                    answer = priorities.length - q.size();
                }
                
            }

        }        
        
        return answer;
    }
}
