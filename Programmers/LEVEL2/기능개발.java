import java.util.Stack;

class Solution {
    
    static class pr{
        int px;
        int cnt;
        
        pr(int px,int cnt){
            this.px = px;
            this.cnt = cnt;
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
      
        int[] days = new int[speeds.length];
        
        for(int i=0; i<speeds.length; i++){
            days[i] = ((100-progresses[i])/speeds[i]);
            if(((100-progresses[i])%speeds[i])!=0){
                days[i]++;
            }
        }
        Stack<pr> st = new Stack<pr>();
        st.add(new pr(days[0],1));
        
        for(int i=1; i< days.length ; i++){
            if(st.peek().px >= days[i]){
                st.peek().cnt++;
            }else{
                st.add(new pr(days[i],1));
            }
        }
        
        int[] answer = new int[st.size()];
        for(int i=st.size()-1; i>=0; i--){
            
            pr p = st.pop();
            answer[i] = p.cnt;
        }
        return answer;
    }
}
