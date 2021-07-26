class Solution {
    public int solution(String s) {
        
        if(s.length() == 1) return 1;
        
        int min = s.length();
        int size = s.length()/2;// 절반 나누고 시작, 변경되는 단위
        int n = 1;
        while(n<=size){
            min = Math.min(min,compare(n,s));
            n++;
        }
        return min;
    }// end of func
    
    public int compare(int n, String s){
        String ans = "";// 결과를 담을 문자열
        String str = ""; // 단위가 될 문자열
        
     // 수학적 표현으로 나누어보기
        int cnt = 1;
        for(int i=0; i<s.length()/n;i++){
            // 횟수
            if(str.equals(s.substring(n*i,(n*i)+n))){
                cnt++;
            }else{
                if(cnt>1){
                    ans+=cnt+str;
                    cnt = 1;
                }else{
                    ans+=str;
                }
            }
            
            str = s.substring(n*i,(n*i)+n);  
            
        }
        // 마지막 처리
               
        if(cnt>1){
            ans+=cnt+str;
            cnt = 1;
        }else{
            ans+=str;
        }
               
        // 나누어지지 않은 남은 부분 붙이기
        if(s.length()%n!=0){
            ans+=s.substring(s.length()-s.length()%n,s.length());
        }
        return ans.length();
    }
    
}// end of main
