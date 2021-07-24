class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int f1 = 1;
        int f2 = 1;
        
        if(n==1 || n ==2) return 1;
        // 반복문을 통한 피보나치
        for(int i=3;i<=n;i++){
            answer = (f1+f2)%1234567;
            f1 = f2;
            f2 = answer; 
        }
        
        return answer;
    }// end of main
    
    // 재귀 함수 -> 시간초과
    // F(N) % 1234567 = ( F(N-1) % 1234567 + F(N-2) % 1234567 ) % 1234567
//     public int fibo(int n){
        
//         if (n == 0){
//             return 0;
//         }
        
//         if (n == 1){
//             return 1;
//         }
        
//         return (fibo(n-1)% 1234567 + fibo(n-2)% 1234567)%1234567;
        
//     }
   
    
}// end of class
