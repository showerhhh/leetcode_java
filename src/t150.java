import java.util.ArrayList;

public class t150 {
    public static void main(String[] args) {
        Solution_150 solution = new Solution_150();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(solution.evalRPN(tokens));
    }
}

class Solution_150 {
    public int evalRPN(String[] tokens) {
        ArrayList<Integer> stack = new ArrayList<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                stack.add(Integer.parseInt(tokens[i]));
            } catch (NumberFormatException e) {
                int right = stack.remove(stack.size() - 1);
                int left = stack.remove(stack.size() - 1);
                if (tokens[i].equals("+")) {
                    stack.add(left + right);
                } else if (tokens[i].equals("-")) {
                    stack.add(left - right);
                } else if (tokens[i].equals("*")) {
                    stack.add(left * right);
                } else if (tokens[i].equals("/")) {
                    stack.add(left / right);
                }
            }
        }
        return stack.get(stack.size() - 1);
    }
}