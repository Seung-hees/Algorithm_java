class Solution {
    boolean solution(String s) {

        String str = s.toLowerCase();
        int cnt_p = 0;
        int cnt_y = 0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i) == 'p'){
                cnt_p++;
            }else if(str.charAt(i) == 'y'){
                cnt_y++;
            }
            
        }
        if(cnt_p == cnt_y){
            return true;
        }

        return false;
    }
}
