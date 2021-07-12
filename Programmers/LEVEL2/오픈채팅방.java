import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> map = new HashMap<>();
        StringTokenizer st = null;
        for(int i=0;i<record.length;i++){
            st = new StringTokenizer(record[i]," ");
            String q = st.nextToken();
            if(q.equals("Enter")){
                map.put(st.nextToken(),st.nextToken());
            }else if(q.equals("Change")){
                map.put(st.nextToken(),st.nextToken());
            }
        }
        
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<record.length;i++){
           st = new StringTokenizer(record[i]," ");
            String s = null;
            String q = st.nextToken();
            if(q.equals("Enter")){
                s = map.get(st.nextToken());
                s+="님이 들어왔습니다.";
                list.add(s);
            }else if(q.equals("Leave")){
                s = map.get(st.nextToken());
                s+="님이 나갔습니다.";
                list.add(s);
            }else{
                continue;
            }
        }
        
        
        String[] answer = new String[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
