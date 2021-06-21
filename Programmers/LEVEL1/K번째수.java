class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
    
        for(int x=0; x<commands.length; x++){
            int i = commands[x][0]; 
            int j = commands[x][1]; 
            int k = commands[x][2]; 
            
            int[] narr = new int[array.length];
            // 복사
            for(int y=0; y<array.length;y++){
                narr[y] = array[y];
             }
        
            
            // 버블 정렬
            for(int n = j-1 ; n>= i-1; n--){
                for (int m = i-1; m < n; m++) {
                    if(narr[m]>narr[m+1]){
                        int tmp = narr[m];
                        narr[m] = narr[m+1];
                        narr[m+1] = tmp;
                    }
                }
            }
            
            answer[x] = narr[i-1+k-1];
        
        }
        
        return answer;
    }
}
