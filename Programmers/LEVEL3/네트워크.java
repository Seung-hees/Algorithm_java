import java.util.*;

class Solution {
    
    private static boolean[] visited;
    private static Queue<Integer> q = new LinkedList<>();
    
    public int solution(int n, int[][] computers) {
        // 컴퓨터의 개수 n, 연결에 대한 정보 computers
        int answer = 0;// 네트워크의 개수
        
        visited = new boolean[n];
        
        for(int i=0; i<n ; i++){
            if(!visited[i]){
                bfs(i,computers,n);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(int r, int[][] computers, int n){
        
        visited[r] = true;
        q.offer(r);
        
        while(!q.isEmpty()){
            int p = q.poll();
            
            for(int i=0; i<n; i++){
                if(computers[p][i] == 1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
            
        }
        
    }
    
    
}// end of class
