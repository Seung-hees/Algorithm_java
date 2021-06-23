import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i< prices.length; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                answer[stack.peek()] = i - stack.peek(); //현재 인덱스 에서 얼마나 떨어져 있는지가 time
                stack.pop();
            }     
            stack.add(i);// 인덱스를 집어 넣기
        }
        
        while(!stack.isEmpty()){ // 값을 구하지 않은 것들
            answer[stack.peek()] = prices.length-1-stack.peek();
            stack.pop();
        }
        
        return answer;
    }
}// end of class
