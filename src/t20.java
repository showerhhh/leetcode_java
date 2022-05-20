import java.util.Stack;

public class t20 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (!stack.empty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (!stack.empty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }
}