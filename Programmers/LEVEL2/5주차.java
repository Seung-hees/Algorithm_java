class Solution {
    private static String alpha[] = {"A","E","I","O","U"};
    private static int cnt,ans = 0; 
    
    public int solution(String word) {
        
        permu(0,"",word);
        return ans;
    }
    
    private static void permu(int idx, String s, String word){
        if(idx == 5){
            return;
        }
        // 앞 자리에서 부터 채워나감.
        for(int i=0; i<alpha.length; i++){
            String str = s + alpha[i];
            cnt++;
            if(str.equals(word)){
                ans = cnt;
                return;
            }
            permu(idx + 1, str, word);
        }
       
    }
}
