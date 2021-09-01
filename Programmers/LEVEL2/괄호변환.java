import java.util.*;

class Solution {
    int pos;

    public String solution(String p) {
        if(p.isEmpty()) return p;

        boolean correct = isCorrect(p);
        String u = p.substring(0, pos);
        String v = p.substring(pos, p.length());

        if(correct){//3번인경우(올바른괄호문자열이라면)
            return u + solution(v);//재귀적으로 solution메소드 호출
        }
        //else
        //올바른문자열이 아니면.
        String answer = "(" + solution(v) + ")";
        for(int i=1; i<u.length()-1; i++){//4-4
            if(u.charAt(i) == '(')
                answer+=")";
            else
                answer+="(";
        }

        return answer;//4-5
    }
    
    boolean isCorrect(String str){
        boolean ret = true;

        int left =0, right = 0;//오른쪽 왼쪽 카운팅
        Stack<Character> mystack = new Stack<>();

        for(int i =0; i<str.length(); ++i){
            if(str.charAt(i) == '(' ){
                left++;
                mystack.push('(');
            }else{
                right++;
                if(mystack.isEmpty()){
                    ret=false;
                }else{
                    mystack.pop();
                }
            }
            if(left==right){//균형잡힌 괄호문자열인경우. (최초로)
                //u,v를 분리하는부분
                pos =i+1;//v의 시작위치이자, u의 length로 사용
                return ret;
            }
        }
        return true;//여기까지 올일은없음.
    }

}
