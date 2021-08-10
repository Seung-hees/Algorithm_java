/* 효율성체크 - 시간초과
import java.util.*;
import java.io.*;

class Solution {
       
    public int solution(int n) {
        int answer = 0;
        String nto2 = Integer.toBinaryString(n);
        int len = nto2.replaceAll("0","").length();
        String mto2 = "";
        int m = n+1;
        while(true){
            mto2=Integer.toBinaryString(m);
            
            if(len == mto2.replaceAll("0","").length()){
                answer = m;
                break;
            }
            m++;
        }
        return answer;
    }
}
*/

import java.util.*;
import java.io.*;

class Solution {
       
    public int solution(int n) {
        int answer = 0;
        String nto2 = Integer.toBinaryString(n);
        int len = Integer.bitCount(n);// Integer.bitCount(n) : 2진수 1의 개수 count
        String mto2 = "";
        int m = n+1;
        while(true){
            mto2=Integer.toBinaryString(m);
            if(len == Integer.bitCount(m)){
                return m;
            }
            m++;
        }
    }
}
