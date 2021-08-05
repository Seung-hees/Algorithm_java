import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1;i<Math.sqrt(n)+1;i++){
            if(n%i==0){
                answer+=i;
                if(i!=n/i){
                    answer+=n/i;
                }
            }
        }
        return answer;
    }
}
