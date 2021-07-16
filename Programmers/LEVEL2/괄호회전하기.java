import java.util.*;
import java.io.*;

class Solution {
    public int solution(String str) {
        int answer = 0;
        int size = str.length();
        
        for(int i=0; i<size;i++){

            String s = str.substring(i)+str.substring(0,i);
            
            Stack<Character> st = new Stack<Character>();
            
            for(int j=0;j<size; j++){
                char ch = s.charAt(j);
                
                if(st.isEmpty()){
                    st.add(ch);
                    continue;
                }
                
                if(st.peek()=='[' && ch == ']'){
                    st.pop();
                }else if(st.peek()=='(' && ch == ')'){
                    st.pop();
                }else if(st.peek()=='{' && ch == '}'){
                    st.pop();
                }else{
                    st.add(ch);
                }
            }
            
            if(st.isEmpty()){
                answer++;
            }
 
        }
        
        return answer;
    }
}
