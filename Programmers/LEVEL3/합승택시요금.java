import java.util.*;
import java.io.*;
// 다익스트라 -> 다시 풀어보기
// 플로이드 워샬
class Solution {
    // s-> 합승 + 합승->a + 합승-> b 가 최소인 값
    public int solution(int n, int s, int a, int b, int[][] fares) {

        int answer = Integer.MAX_VALUE;
        // 가중치 행렬
        int[][] weight = new int[n+1][n+1];
        
        for(int i=0; i<fares.length; i++){
            weight[fares[i][0]][fares[i][1]] = fares[i][2];
            weight[fares[i][1]][fares[i][0]] = fares[i][2];
        }
     
        for(int k=1; k<n+1; k++){
           for(int i=0; i<n+1; i++){
               if(i==k) continue;
               for(int j=0; j<n+1; j++){
                   if(i==j || j==k) continue;
                   if(weight[i][k] == 0 ||weight[k][j] == 0 ) continue;
                   if(weight[i][j] == 0) weight[i][j] = weight[i][k] + weight[k][j];
                   else weight[i][j] = Math.min(weight[i][j],weight[i][k]+weight[k][j]);
               }
           }
            
        }
        
        for(int i=1; i <n+1;i++){
            if(weight[s][i]+weight[i][a]+weight[i][b] == 0 ) continue;
            answer = Math.min(answer,weight[s][i]+weight[i][a]+weight[i][b]);
        }

        
        return answer;
    }
}
