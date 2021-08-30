import java.util.*;
import java.io.*;

// 자기자신을 평가한 점수가 유일한 최고점 또는 최저점이라면 그 점수는 제외하고 평균
class Solution {
    public String solution(int[][] scores) {
        StringBuilder sb = new StringBuilder();
        int max, min, sum;
        int len = scores.length;
        boolean chk ;
        for(int i=0; i<len; i++){
            max = -1;
            min = 101;
            sum = 0;
            chk = true;
            
            for(int j=0;j<len;j++){
                
                if(i!=j && scores[i][i] == scores[j][i]){
                    chk = false;
                }
                
                max = Math.max(max, scores[j][i]);
                min = Math.min(min, scores[j][i]);
                sum+=scores[j][i];
            }
            
            int avg = 0; 
            int self = scores[i][i];
            if(chk && (max == self || min == self)){
                sum-=self;
                avg = sum/(len-1);
            }else{
                avg = sum/len;
            }
            
            switch(avg/10) {
                case 9: sb.append("A");break;
                case 8: sb.append("B");break;
                case 7: sb.append("C");break;
                case 6:
                case 5: sb.append("D");break;
                default: sb.append("F");break;
            }
            
        }
        return sb.toString();
    }
}
