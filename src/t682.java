import java.util.Stack;

public class t682 {
    public static void main(String[] args) {
        String[] ops = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        Solution_t682 solution = new Solution_t682();
        System.out.println(solution.calPoints(ops));
    }
}

class Solution_t682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(a + b);

            } else if (ops[i].equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (ops[i].equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(ops[i]));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}