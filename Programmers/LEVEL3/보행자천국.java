class Solution {
	  int MOD = 20170805;
	  public int solution(int m, int n, int[][] cityMap) {
	      // dp[][][0] 아래쪽, dp[][][1] 오른쪽
          // dp 범위 초과할까봐 테두리를 만들어줌.
          int[][][] dp = new int[m + 1][n + 1][2];
	      
          dp[1][1][0] = dp[1][1][1] = 1;//시작점(1,1) 경로 1가지
          
          for(int r = 1 ; r <= m ; ++r){
              for(int c = 1 ; c <= n ; ++c){
                  if(cityMap[r - 1][c - 1] == 0){
                      dp[r][c][0] += (dp[r - 1][c][0] + dp[r][c - 1][1]) % MOD;
                      dp[r][c][1] += (dp[r - 1][c][0] + dp[r][c - 1][1]) % MOD;
                  } else if(cityMap[r - 1][c - 1] == 1){
                      dp[r][c][0] = 0;
                      dp[r][c][1] = 0;
                  } else {
                      dp[r][c][0] = dp[r - 1][c][0];
                      dp[r][c][1] = dp[r][c - 1][1];
                  }
              }
          }
          return dp[m][n][0]; 
      }
}
