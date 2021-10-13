import java.util.*;

class Solution {

    public boolean solution(String[] phone_book) {
        // 접두어인 경우가 있으면 false, 그렇지 않으면 true
        
        //1) 이중 loop
        // + startWith 함수 : String 함수 -> 시간 초과
//         for(int i=0; i<phone_book.length-1;i++){
//             for(int j=i+1; j<phone_book.length;j++){
//                 if(phone_book[i].startsWith(phone_book[j])){
//                     return false;
//                 }
                
//                 if(phone_book[j].startsWith(phone_book[i])){
//                     return false;
//                 }
//             }
//         }
//        return true;
        
        //2) hashmap
        
        HashMap<String , Integer> map = new HashMap<>();
        
        for(int i=0; i<phone_book.length;i++){
            map.put(phone_book[i],i);// 모든 전화번호 삽입
        }
        //containsKey, substring
        for(int i=0; i <phone_book.length; i++){
            // 해당 되는 문자열 비교
            for(int j=1; j<phone_book[i].length();j++){
                if(map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }   
            }
        }
        
        return true;

    }
}
