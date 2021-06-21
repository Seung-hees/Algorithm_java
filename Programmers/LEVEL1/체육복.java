class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] clothes = new int[n+1];
        
        // 잃어버린 학생
        for(int i=0; i<lost.length;i++){
            clothes[lost[i]]--;
        }
        
        // 여유를 가지고 있는 학생
        for(int i=0; i<reserve.length;i++){
            clothes[reserve[i]]++;
        }
        
        // 나머지는 그냥 0
        // 확인
        for(int i=1; i<n+1 ; i++){
            if(clothes[i]<0){
                  if(i == 1){
                if(clothes[i+1] == 1){
                    //0으로 만들기
                    clothes[i+1]--;
                    clothes[i]++;
                }
            }else if(i == n){
                if(clothes[i-1] == 1){
                    //0으로 만들기
                    clothes[i-1]--;
                    clothes[i]++;
                }
            }else{
                if(clothes[i-1] == 1){
                    clothes[i-1]--;
                    clothes[i]++;
                }else if(clothes[i+1] ==1){
                    clothes[i+1]--;
                    clothes[i]++;
                }
            }
            }
          
        }
        
        for(int i=1; i<n+1; i++){
            if(!(clothes[i]<0)){
                answer++;
            }
        }
    
        
        return answer;
    }
}
