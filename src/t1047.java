import java.util.Stack;

public class t1047 {
    public static void main(String[] args) {
        String S = "abbaca";
        Solution_t1047 solution = new Solution_t1047();
        System.out.println(solution.removeDuplicates(S));
    }
}

class Solution_t1047 {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            if (ch == stack.peek()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}