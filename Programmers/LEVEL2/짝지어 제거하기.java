import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
			char st = s.charAt(i);
			if (stack.isEmpty()) {// 아예 빈칸이었다면 넣기
				stack.add(st);
			} else {// 아니라면
				if (stack.peek() == st) {
					stack.pop();// 꺼내기
				} else {
					stack.add(st);
				}
			}
		}
		if(stack.isEmpty()) {
			return 1;
		}else {
			return 0;
		}
    }
}
