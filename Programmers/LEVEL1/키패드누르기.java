import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int Lr = 3;// 처음 왼쪽 손가락 행
        int Lc = 0;// 열
        
        int Rr = 3;// 처음 오른쪽 손가락 행
        int Rc = 2;// 열
        
        int r = 0;// 현재 행 
        int c = 0;// 현재 열
        
        for(int i=0; i<numbers.length;i++){
            if(numbers[i] == 0){
                r = 3;
                c = 1;
            }else{
             r = (numbers[i]-1)/3;
             c = (numbers[i]-1)%3;
            }
            /////////////설정
           
            if(c == 0){// 무조건 왼쪽
                Lr = r; Lc = c;/// 바꿔줌
                answer +="L";
                
            }else if(c==2){
                Rr = r; Rc = c;/// 바꿔줌
                answer+="R";
            }else{
                
                int Ldis = Math.abs(Lr-r)+Math.abs(Lc-c);
                int Rdis = Math.abs(Rr-r)+Math.abs(Rc-c);
                if(Ldis == Rdis){
                    if(hand.equals("left")){
                        Lr = r; Lc = c;/// 바꿔줌
                         answer +="L";
                    }else{
                        Rr = r; Rc = c;/// 바꿔줌
                         answer+="R";
                    }
                    
                    
                }else if(Ldis>Rdis){
                     Rr = r; Rc = c;/// 바꿔줌
                     answer+="R";
                }else{
                     Lr = r; Lc = c;/// 바꿔줌
                     answer+="L";
                }
            }

        }
        
 
        
        return answer;
    }
}
