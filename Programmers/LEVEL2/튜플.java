import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        // split 함수 대신 사용 ! split 함수는 String 배열을 반환
        /// split("{}") 로 할 경우  정확히 {} 가 들어가야지 나누어진다.
        // 이와 다르게 { 또는 } 이 들어갈 경우 분리해주는 StringTokenizer
        
        StringTokenizer st = new StringTokenizer(s, "{}");
        // hasMoreTokens() : boolean 형 다음의 nextToken을 반환
        // countTokens() : int 형 , 남아있는 token 의 개수를 반환
        ArrayList<String> list = new ArrayList<String>();
        
        // 리스트 삽입
        while(st.hasMoreTokens()){
            String tmp = st.nextToken();
            if(!tmp.equals(",")){
                list.add(tmp);
            }
        }
        
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.length() - o2.length();// 오름차순
            }
        });
            
        ArrayList<String> ans = new ArrayList<>();
        
        for(String temp : list){
            String[] arr = temp.split(",");
            
            for(int i=0; i<arr.length; i++){
                if(!ans.contains(arr[i])){
                    ans.add(arr[i]);
                }
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = Integer.parseInt(ans.get(i));
        }
        

        return answer;
    }// end of main
}// end of class
