// 나는 최소 공배수 % 가 아닌 - 로 구하는 방법을 사용해 왔는데, 시간 초과가 난다.
// 최소 공배수 = 두 수의 곱 / 두 수의 최소공약수

class Solution {

    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=0; i<arr.length; i++){
            answer = (answer*arr[i])/gcd(answer,arr[i]);
        }
        return answer;
    }// end of func
    
    
    private int gcd (int a , int b){
        if(a<b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        if(b == 0) return a;
        else return gcd(b, a%b);
        
    }

    
    
}// end of solution
