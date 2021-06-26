import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int answer = 1;
        
        for(int i=0; i<clothes.length; i++){
           
            if(map.get(clothes[i][1]) == null){// 현재 의상 존재하지 않을때
                map.put(clothes[i][1],1);
            }else{
                map.put(clothes[i][1],map.get(clothes[i][1])+1);// 존재할때
            }
        }
        
        for(String s : map.keySet()){
            answer*=(map.get(s)+1);// 안입는 경우를 한가지씩 추가 해서 곱해주기
        }
        
        return answer-1;// 모두 안입는 경우 -1
    }
}
