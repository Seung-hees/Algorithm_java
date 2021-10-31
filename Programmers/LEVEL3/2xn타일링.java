import java.util.*;
import java.io.*;
// 세로 2 , 가로 n 채워야 한다.
// DP 문제 ..
// N-1 개가 차있는 경우 : 단 1개의 타일만을 채울 수 있음. (그대로 사용)
// N-2 개가 차있는 경우 : 가로가 2개이므로 세로 2개 , 가로 2개 의 경우 2가지 이지만 세로 2개는 N-1에 포함 된다. (그대로 사용)
// N-3 개가 차있는 경우 : 모두 N-1 개, N-2 개 일때 경우가 포함 된다.

// 점화식 : f(n) = f(n-1)+ f(n-2) : 피보나치


class Solution {
    public int solution(int n) {

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3;i < n+1;i++){
            dp[i] = dp[i-1] + dp[i-2]; 
            dp[i] = dp[i]%1000000007;
        }
        return dp[n];
    }
}
