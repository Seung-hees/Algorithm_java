class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(0,0,numbers,target);
        return answer;
    }

    static int dfs(int idx, int sum ,int[] numbers, int target){
        //기저조건
        if(idx == numbers.length){
            if(target == sum){
                return 1;
            }
            return 0;
        }
        
        return dfs(idx + 1, sum - numbers[idx],numbers,target) + dfs(idx+1, sum+numbers[idx],numbers,target);
        
    }// end of dfs
  
}// end of class
