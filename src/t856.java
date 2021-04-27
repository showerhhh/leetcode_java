import java.util.Stack;

public class t856 {
    public static void main(String[] args) {
        String S = "(()(()))";
        Solution_t856 solution = new Solution_t856();
        System.out.println(solution.scoreOfParentheses(S));
    }
}

class Solution_t856 {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();
                if (v == 0) {
                    stack.push(w + 1);
                } else {
                    stack.push(w + 2 * v);
                }
            }
        }
        return stack.peek();
    }
}