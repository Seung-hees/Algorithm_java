class Solution {
    public boolean solution(String s) {
        
        if(s.length()!=4 && s.length()!=6){
            return false;
        }
        
        for(int i=0;i<s.length();i++){
            char st = s.charAt(i);
            if(st< '0' || st > '9'){
                return false;
            }
        }
        
        return true;
    }
}
