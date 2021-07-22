class Solution {
    public int[] solution(int n) {
        
        int max = n*(n+1)/2;
        
        int map[][] = new int[n][n];// 맵의 절반만 사용
        int top = 0;// 세로 인덱스
        int left = 0;// 가로 인덱스 
        int tmp = 0;// 채워야 하는 개수 n개 세로, 가로 , 대각선 / n-1개 세로, 가로 , 대각선
        int i = 1;
        
        // 1단계 : 세로 , 2단계 : 가로 , 3단계 : 북서 방향 대각선
        while(i!= max+1){
            // 세로
            for(; top < n-tmp; top++){
                map[top][left] = i++;
            }
            top--; // 오버되어 더해줬으니 다시 빼줌
            left++;// 그 옆칸 부터 시작
            
            // 가로
            for(;left<n-tmp;left++){
                if(map[top][left] !=0) break;// 가로 할 차례가 되었을 때 , 끝나야 하는 분기점이 생김
                map[top][left] = i++;
            }
            top--;// 한칸 줄이기
            left-=2;// left 두칸 줄이기
            
            // 대각선
            for(;top>tmp && left>tmp ; top--,left--){
                map[top][left] = i++;
            }
            
            top+=2;
            left++;
            tmp++;
    

        }

        int[] answer = new int[max];
        int idx = 0;
        for(int j=0; j<n; j++){
            for(int k = 0; k<n; k++){
                if(map[j][k] == 0 ) continue;
                answer[idx++] = map[j][k];
            }
        }
        
        return answer;
    }
}
