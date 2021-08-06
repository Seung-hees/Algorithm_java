/*DFS 시간초과!
import java.util.*;
import java.io.*;

class Solution {
    private static int len = 0;
    private static int max = 0;
    
    public static void main(String[] args) {
    	int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
    	
    	len = land.length;
    	
    	for(int i=0;i<4;i++){
    		dfs(1,i,land[0][i],land);// 행과 그 다음 열, 점수
    	}
    	System.out.println(max);
	}
    
    private static void dfs(int r, int c, int num, int[][] land){
        
        if(r==len){
            max = Math.max(max,num);
            //System.out.println(max);
            return;
        }
        
        for(int i=0; i<4; i++){
        	if(i==c) continue;
            dfs(r+1,i,num+land[r][i],land);
        }

    }
*/    
    
}

import java.io.*;
import java.util.*;
/*
DP 문제 
i+1의 최댓값은 i 최댓값 + i+1에서 선택할 수 있는 최댓값
dp 배열의 첫번째 값들은 그대로 두고 두번째 값 배열들을 가능한 것 중 큰 값 골라서 더해주기!

*/
class Solution {

    public int solution(int[][] land) {
        for(int i=1; i<land.length; i++){
            
            land[i][0] +=Math.max(Math.max(land[i-1][1],land[i-1][2]),land[i-1][3]);
            land[i][1] +=Math.max(Math.max(land[i-1][0],land[i-1][2]),land[i-1][3]);
            land[i][2] +=Math.max(Math.max(land[i-1][0],land[i-1][1]),land[i-1][3]);
            land[i][3] +=Math.max(Math.max(land[i-1][1],land[i-1][2]),land[i-1][0]);
        }

        int[] answer = land[land.length-1];
        Arrays.sort(answer);

        return answer[answer.length-1];
    }

}





