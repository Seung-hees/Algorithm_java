class Solution {
    // 키(M*M) 와 자물쇠 (N*N) 가 2차원 배열로 존재
    // 배열에서 값 1은 돌기, 0은 홈
    // 주어진 키를 가지고 자물쇠의 돌기 부분과 겹치지 않고 홈에 넣는 다면 TRUE
    // 키는 90도(시계방향)으로 회전하여 자물쇠 열기
    
    private static int N,M;
    private static int count_lock = 0;
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        M = key.length; // key 사이즈
        N = lock.length;// 자물쇠 사이즈
        
        // 자물쇠의 홈부분 개수
        for(int i=0; i<lock.length; i++){
            for(int j=0; j<lock.length; j++){
                if(lock[i][j] == 0) count_lock++;
            }
        }
        
        // key는 시계방향 90도 회전
        for(int r=0; r<4; r++){
            key = rotate(key);
            
            //lock 을 풀 수 있는 지 판단
            // (key size - 1)*2 만큼 사이즈를 확장해야 모든 범위에서 측정 가능
            int size = M-1;
            for(int i = (-size); i<N;i++){
                for(int j= (-size); j<N;j++){
                    if(openLock(key, lock, i,j)){
                        return true;
                    }
                }
            }
        }

        return answer;
    }// end of func
    
    private static boolean openLock(int[][] key, int[][] lock, int row , int col){
        // 해당 좌표를 기준으로 key size 만큼 확인
        int cnt = 0;
        for(int i=0; i<M; i++){
            int moveY = row + i;
            for(int j = 0; j<M; j++){
                int moveX = col +j;
                
                // lock map 맵에 속하면서 key가 잘 맞는 지 확인
                if(isRanged(moveX,moveY)){
                    if(key[i][j] == 1 && lock[moveY][moveX] == 0) cnt++;
                    else if(key[i][j] == 1 && lock[moveY][moveX] == 1) return false;
                }
            }
        }
        if(cnt != count_lock) return false;
        return true;
    }
    private static boolean isRanged(int x, int y){
        if(x>=0 && y>=0 && x<N && y<N) return true;
        return false;
    }
    
    
    private static int[][] rotate(int[][] key){
        int[][] tmp = new int[M][M];
        for(int i=0; i<M; i++){
            for(int j=0; j<M ; j++){
                tmp[i][j] = key[M-1-j][i];// 회전!!!
            }
        }
        return tmp;
    }
}// end of class
