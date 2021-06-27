// dfs, begin : 시작하는 단어, target: 종료되어야 하는 단어
// 각 단어를 하나씩 변경해가면서, words에 있는지 check 하고 사용중이라면 visited 배열 체크해준다.
// 최소값을 구해준다.
// 없다면 0

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = words.length+1;
        
        for(int i=0; i<words.length; i++){
            boolean[] visited = new boolean[words.length];// 방문 배열 생성
            // 한글자만 다른지 확인
            if(differ(begin, words[i])){
                //dfs
                answer=Math.min(answer ,dfs(words[i], target, i, words, visited, 1));
            }
        }
        
        if(answer == words.length+1){
            return 0;
        }
        return answer;
    }
    
    public boolean differ(String a, String b){
        int cnt = 0;
        
        for(int i=0; i<a.length() ;i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
            }
        }
        
        if(cnt == 1){
           return true;
        }
        
        return false;
    }
    
    public int dfs(String begin, String target, int idx, String[] words, boolean[] visited, int cnt){
        // 같아졌다면
        if(begin.equals(target)){
            return cnt;
        }
        // 이미 사용한 단어라면
        if(visited[idx]){
            return cnt;
        }
        
        visited[idx] = true;
        
        // 더이상 못갈 때 0
        int ans = 0;
        
        for(int i=0; i<words.length;i++){
            // 자기 자신 아니고, 한 글자만 다를 때, 방문하지 않은 단어일때
            if(idx != i && differ(begin, words[i]) && !visited[i]){
                ans = dfs(words[i], target, i, words, visited, cnt+1);
            }
        }
        return ans;
        
    }
    
    
}// end of class
