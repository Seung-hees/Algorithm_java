class Solution {
    private String[] week = {"THU", "FRI","SAT", "SUN" ,"MON" ,"TUE", "WED",};
    private int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public String solution(int a, int b) {
        // a는 month, b는 day 1/1 금요일
        int total = 0;
        for(int i=1; i<a; i++){
            total += days[i];
        }
        total +=b;
        
        String answer = week[total%7];
        return answer;
        
    }
}
