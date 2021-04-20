import java.util.ArrayList;

public class t402 {
    public static void main(String[] args) {
        Solution_t402 solution = new Solution_t402();
        String num = "10200";
        int k = 1;
        System.out.println(solution.removeKdigits(num, k));
    }
}

class Solution_t402 {
    public String removeKdigits(String num, int k) {
        ArrayList<Character> stack = new ArrayList<Character>();  //单调栈
        for (int i = 0; i < num.length(); i++) {
            char t = num.charAt(i);
            while (k != 0 && !stack.isEmpty() && stack.get(stack.size() - 1) > t) {
                stack.remove(stack.size() - 1);
                k--;
            }
            stack.add(t);
        }
        //若k仍然不为0，强制删除末尾k位。
        while (k != 0) {
            stack.remove(stack.size() - 1);
            k--;
        }

        //从第一个不为0的数字开始构造字符串。
        int i = 0;
        for (; i < stack.size() && stack.get(i) == '0'; i++) {
        }

        StringBuilder s = new StringBuilder();
        for (; i < stack.size(); i++) {
            s.append(String.valueOf(stack.get(i)));
        }

        if (s.length() == 0) {
            return "0";
        } else {
            return s.toString();
        }
    }

    class IncStack {
        ArrayList<Character> stack;

        IncStack() {
            stack = new ArrayList<Character>();
        }

        void push(Character t) {
            while (!stack.isEmpty() && stack.get(stack.size() - 1) > t) {
                pop();
            }
            stack.add(t);
        }

        int pop() {
            return stack.remove(stack.size() - 1);
        }
    }
}