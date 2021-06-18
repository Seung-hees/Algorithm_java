class Solution {
    public String solution(int n) {
        String answer = "";
    
        while(n!=0){
            int num = n%3;
            if(num == 1){
                answer= "1"+answer;
            }else if(num == 2){
                answer ="2"+answer;
            }else{
                answer="4"+answer;
            }
            n = n/3;
            if(num == 0){
                n-=1;
            }
        }
        
        return answer;
    }
}
