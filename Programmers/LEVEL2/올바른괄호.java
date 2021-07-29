import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {

        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length();i++){
            
            if(i == 0 && s.charAt(i) == ')'){
                return false;
            }
            
            if(s.charAt(i) == '('){
                st.add('(');
            }else{
                if(st.size()==0){
                    return false;
                }
                st.pop();
            }
        }        
        if(st.size()==0){
            return true;
        }else{
            return false;
        }
        
    }
}
