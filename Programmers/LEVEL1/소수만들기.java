import java.util.*;
import java.io.*;

class Solution {
    private static int[] selected;
    private static int answer = 0;
    public int solution(int[] nums) {
        
        selected = new int[3];
        comb(0,0,nums);

        return answer;
    }
    
    public void comb(int cnt, int start, int[] nums){
        
        if(cnt == 3){
            if(ischecked(selected)){
                // System.out.println(Arrays.toString(selected));
                answer++;
            }
            return;
        }
        
        for(int i=start; i<nums.length; i++){
            selected[cnt] = nums[i];
            comb(cnt+1, i+1, nums);
        }
        
        
    }
    
    public boolean ischecked(int[] arr){
        int n = 0;
        for(int i=0; i<arr.length;i++){
            n += arr[i];
        }
        
        for(int j=2; j<n;j++){
            if(n%j == 0){
                return false;
            }
        }
        return true;
        
    }
}
