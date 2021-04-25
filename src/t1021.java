import java.util.Stack;

public class t1021 {
    public static void main(String[] args) {
        String S = "()()";
        Solution_t1021 solution = new Solution_t1021();
        System.out.println(solution.removeOuterParentheses(S));
    }
}

class Solution_t1021 {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder();
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                stack.pop();
            }
            if (stack.isEmpty()) {
                end = i;
                result.append(S.substring(start + 1, end));
                start = end + 1;
            }
        }
        return result.toString();
    }
}