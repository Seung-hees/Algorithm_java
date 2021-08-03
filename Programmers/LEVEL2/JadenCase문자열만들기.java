import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.toLowerCase().split(" ");
        String tmp = "";
        
        for(int i=0; i<str.length; i++){
            tmp = str[i];
            if(tmp.equals("")){
                answer+=" ";
                continue;
            }
                
            answer+= tmp.substring(0,1).toUpperCase()+tmp.substring(1,tmp.length());
            answer+=" ";
        }
        if(s.charAt(s.length()-1)!=' '){
            answer=answer.trim();
        }
        
        return answer;
    }
}
