import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        // 초기값 left = 1, right = 가장 오래걸리는 심사관이 모든 사람을 심사하는 시간
        // 이분 탐색 시간(mid) 을 사용하여 각 심사위원들이 몇명을 처리할 수 있는 지 계산
        // 걸리는 시간을 계속하여 이분탐색하며 반복문을 돌아주며 최소 시간을 구해준다.
        Arrays.sort(times);
        return binarySearch(times, n, times[times.length-1]);
    }
    
    private long binarySearch(int[] times, int n, long max){
        long left = 1, right = max * n;
        long mid = 0 , sum = 0, answer = 0;
        
        while(left<=right){
            mid = (left + right) /2;
            sum = 0; // 심사인원
            for(int i=0; i<times.length; i++){//빨리 심사하는 심사관 순으로 심사처리
                sum+= mid/times[i];
            }
            if(sum < n){// 해야할 인원보다 심사처리 못했다. 시간이 더 필요
                left = mid+1;
            }else {// 더 맡을 수 있으므로 시간줄임
                right = mid -1;
                answer = mid;// 나누어떨어지지 않을 수 있다., 모든 경우에 대비
                
            }
               
        }
        return answer; 
    }
    
}
