class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int n = brown + yellow;
        int r = 0;
        int c = 0;
        for(int i = n-1; i>0; i--){
            if(n%i==0){
                r = i;
                c = n/i;
                
                if((r-2)*(c-2) == yellow){
                    break;
                }
            }
        }
        
        answer[0] = r;
        answer[1] = c;
        
        return answer;
    }
}
