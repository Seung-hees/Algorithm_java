import java.util.*;
import java.io.*;

class Solution{
    
    public int solution(int [][]board)
    {

        int max = 0;        
        int[][] newBoard = new int[board.length+1][board[0].length+1];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                newBoard[i+1][j+1] = board[i][j]; 
            }
        }
        
        for(int i=1; i<newBoard.length; i++){
            for(int j=1; j<newBoard[0].length;j++){
                
                if(newBoard[i][j] == 1){
                    int left = newBoard[i-1][j]; //왼쪽
                    int up = newBoard[i][j-1]; // 위쪽
                    int leftUp = newBoard[i-1][j-1]; // 왼위 대각선
                    // 최솟값을 찾아서 1을 더해주는 방식
                    // 값이 다 같은 경우(1로 정사각형) 더해준다.
                    int min = Math.min(left,Math.min(up,leftUp));
                    newBoard[i][j] = min +1;
                    max = Math.max(max, newBoard[i][j]);
                }
                
            }
        }
        
        return max * max;
    }
}
