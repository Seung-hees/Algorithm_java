import java.util.*;
import java.util.Map.Entry;

// key 는 중복 불가 , value는 중복 가능
class Solution {
    public String solution(String[] participant, String[] completion) {
        int val = 0;
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(String part : participant){
            if(map.get(part) == null){
                map.put(part,1);
            }else{
                val = map.get(part) + 1;
                map.put(part,val);
            }
        }
        
        for(String comp : completion){
            val = map.get(comp) - 1;
            map.put(comp,val);
        }
        
        
        // for(String key : map.ketSet()){
        //     if(map.get(key) == 1){
        //         answer = key;
        //     }
        // }
        
        for(Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                answer = entry.getKey();
                break;
            }
        }
        
        
        return answer;
      
    }
}// end of class
