import java.io.*;
import java.util.*;

class Solution {
    
    private HashMap<String,Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
    
        
        for(String s : orders){
            char[] order = s.toCharArray();
            Arrays.sort(order);// 먼저 정렬 하기
            for(int i=0; i< course.length; i++){
                comb(order, course[i], 0, 0, "");
            }
        }
        
        int[] course_arr = new int[course[course.length -1]+1];// 코스 4까지 이면 4
        for(String key: map.keySet()){
            if(map.get(key)>=2){//2개 이상 , 해당 코스길이 중 가장 큰값 구하기
                course_arr[key.length()] = Math.max(map.get(key),course_arr[key.length()]);
            }
        }
        
        // 각 코스 별 가장 많이 주문된 횟수가 채워진 상태임.
        
        List<String> answerlist = new ArrayList<>();
        for(String key : map.keySet()){
            for(int i=0; i<course_arr.length;i++){
                if(course_arr[i] == 0) continue;
                if(key.length() == i && map.get(key) == course_arr[i]){
                    answerlist.add(key);
                }
            }
            
        }
        
        Collections.sort(answerlist);
        
        String[] answer = answerlist.toArray(new String[answerlist.size()]);
        
        return answer;
    }
    
    public void comb(char[] orders, int size, int cnt,int start, String str){
        
        if(cnt == size){
            if(!map.containsKey(str)){
                map.put(str, 1);
            }else{
                map.put(str, map.get(str)+1);
            }
            return;
        }
        
        for(int i=start; i<orders.length; i++){
            comb(orders, size, cnt+1,i+1, str+orders[i]);
            
        }

    }// end of permu
    
}
