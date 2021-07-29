import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] str = s.split(" ");
        int n = 0;
        for(int i=0;i<str.length;i++){
            
            n = Integer.parseInt(str[i]);
            if(max<n) max = n;
            if(min>n) min = n;
            
        }
        
        
        answer = min + " "+ max;
        
        
        return answer;
    }
}
