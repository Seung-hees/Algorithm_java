import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
       
        for(int i = 0; i<citations.length; i++){
            int h = citations.length - i; // h편 이상 구할려고.
            
            if(citations[i]>=h){// 논문 인용횟수가 h이상인지 확인
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}
