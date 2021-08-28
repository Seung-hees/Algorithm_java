class Solution {
    public int solution(int left, int right) {
        // 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀수
        int answer = 0;
        for(int n=left; n<=right; n++){
            
            int cnt = 0;
            for(int i=1; i<=n;i++){
                if(n%i==0){
                    cnt++;
                }
            }
            
            if(cnt%2==0){
                answer+=n;
            }else{
                answer-=n;
            } 
            
        }
        
        
        return answer;
    }
}
