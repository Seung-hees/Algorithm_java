/* 시간초과(완탐)
import java.util.*;
import java.io.*;

class Solution {
    private static int limit = 0;
    private static int sum = 0;
    private static int max = 0;
    private static int[] numbers;
    private static int[] answer;

    public int[] solution(int n, int s) {

        numbers = new int[n];// 자연수 n개로 이루어진 집합
        answer = new int[n];
        limit = n;
        sum = s;
        
        
        //원소의 합이 s
        
        // 조합 이고 , 1~n 까지 
        comb(1,0);
        if(max == 0){
            int[] ans = {-1};
            return ans;
        }else{
             return answer;
        }

    }
    private void comb(int start, int cnt){
        if(cnt == limit){
            int total = 0;
            int multi = 1;
            
            for(int i=0; i<limit; i++){
                multi*=numbers[i];
                total+=numbers[i];
            }
            
            if(total == sum && multi > max){
                max = multi;
                answer = Arrays.copyOf(numbers,limit);
            }
            
            return;
            
        }
        
        for(int i=start;i<sum;i++){
            numbers[cnt] = i;
            comb(i,cnt+1);
        }
    }
}*/
// 최고의 집합 = 두수의 차가 최소일 때
import java.util.*;
import java.io.*;

class Solution {
    
    public int[] solution(int n, int s) {
        if(n > s){
            return new int[] {-1};
        }
        int[] answer = new int[n];
        for(int i=0; i<answer.length; i++){
            answer[i] = s/n;// 우선 s/n 으로 다 채우기
        }
        for(int i= n-s%n; i<n; i++){
            answer[i]++;// 나머지 1씩 나눠가지기
        }
      
        return answer;

        
    }
}


