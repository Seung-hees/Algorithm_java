import java.util.*;

class Solution {
    static boolean[] visited;
    ArrayList<String> answers;
    
    public String[] solution(String[][] tickets) {
        
        answers = new ArrayList<String>(); 
        
        // 방문 배열 생성
        visited = new boolean[tickets.length];
        
    // 출발은 무조건 , ICN
       
        dfs("ICN", "ICN", tickets, 0);
        
        // 알파벳순 정렬
        Collections.sort(answers);
        
        String[] answer = answers.get(0).split(" ");// 알파벳 순 가장 앞 문자열 배열로 만들기    
  
        return answer;
    }
    
    public void dfs(String cur, String answer, String[][] tickets, int cnt ){
        // 기저 조건
        if(cnt == tickets.length){
            answers.add(answer);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            
            if(!visited[i] && tickets[i][0].equals(cur)){
                visited[i] = true;
                dfs(tickets[i][1], answer+" "+tickets[i][1],tickets,cnt+1);
                visited[i] = false;
            }
        }
        
        //return;
    }
    
    
}
