import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        // 문자열을 리턴을 해줄 String 배열
        String[] str = new String[numbers.length];
        
        // int 배열 String 배열로 변환
        for(int i=0; i<numbers.length;i++){
            str[i] = String.valueOf(numbers[i]);
        }
        
        // a.compareTo(b)
        // 내림차순 : (o2+o1).compareTo(o1+o2);
        // 오름차순 : (o1+o2).compareTo(o1+o2);
        
        // 내림차순
        Arrays.sort(str, new Comparator<String>(){
           @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
                // 오름 차순 정렬
            }
            
        });
        
        //0값이 중복일 경우 {0,0,0}
        // 답이 000이 나오면 안되므로 첫번째값이 0이면 0리턴
        if(str[0].equals("0")) 
            return "0";
        //0이 아니라면
        for(String s : str) 
            answer +=s;
        
        return answer;
    }
}
