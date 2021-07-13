import java.util.*;
import java.io.*;
// replace(a,b) a를 b로 대체 시켜준다
// replaceAll([abc],k) 정규식 표현으로 a,b,c들을 k로 바꿔준다.
// replaceAll([^0-9],k) 정규식 표현으로 숫자가 아닌 것들을 k로 바꿔준다.

class Solution {
    public String solution(String new_id) {
        //1단계
        String st1 = new_id.toLowerCase();
        //2단계
        // step2 = st1.replaceAll("[^-_.a-z0-9]", ""); // 2단계
        char[] st1_arr = st1.toCharArray();
        StringBuilder step2 = new StringBuilder();
        for(char c : st1_arr){
            if((c >= 'a' && c<='z') || (c>='0' && c<='9') || c == '-' || c == '.' ||c=='_'){
                step2.append(c);
            } 
        }
        
        //3단계
        String step3 = step2.toString();
        while (step3.contains("..")) {
            step3 = step3.replace("..", ".");
        }
        // 4단계 : 처음과 마지막 위치에 있는 마침표 제거
        
        String step4 = step3;
        if(step4.length()>0){
            if(step4.charAt(0) == '.'){
                step4 = step4.substring(1,step4.length()); 
            }
        }
        
        if(step4.length()>0){
            if(step4.charAt(step4.length()-1) == '.'){
                step4 = step4.substring(0,step4.length()-1); 
            }
        }
        
        //5단계
        String step5 = step4;
        if(step5.length()==0){
            step5 = "a";
        }
        
        //6단계  : 16자이 상이면 15자 제외 나머지 제거. 만약 제거 후, . 이 new_id 끝에 위치한다면 끝에 위치한 마침표 (.) 제거
        String step6 = step5;
        if(step6.length()>=16){
            step6 = step6.substring(0,15);
        }
        if(step6.charAt(step6.length()-1)=='.'){
            step6 = step6.substring(0,step6.length()-1);
        }
        
        // 7단계
        String step7 = step6;
        if (step7.length() <= 2) {
            for (int i = step7.length(); i < 3; i++) {// 3이 돨때까지
                step7 = step7 += step7.charAt(step7.length() - 1);
            }
        }
        String answer = step7;
        return answer;
    }
}
