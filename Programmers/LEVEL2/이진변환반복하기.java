// replaceAll 함수 사용법
// ** String str = null 보다 "" 이 더 빠름
// 이진법은 문자 더해줄 때 앞에서 더해줌!!

class Solution {
    public int[] solution(String s) {
        
        int[] answer = new int[2];
        
        int cnt = 0;
        int zero = 0;// 0의 개수
        int one = 0;
        while(true){
            
            if(s.length()==1){
                break;
            }
            
            for(int i=0; i<s.length();i++){
                if(s.charAt(i) == '0'){//1의 개수
                    answer[1]++;
                }else{//0의 개수
                    one++;
                }
            }
            
            //3) 이진 변환 
            // 이진법 함수
            // s = Integer.toBinaryString(one);
            String str = "";
            while(one>0){
                str=one%2+str;
                one/=2;
            }
            one = 0;
            s = str;
            answer[0]++;
            
        }
        
        return answer;
        
        
    }// end of func
}// end of solution
