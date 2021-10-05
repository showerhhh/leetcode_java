import java.util.Stack;

public class t面试题_1626 {
    public static void main(String[] args) {
        // 未完成，需要考虑多位的数字
        System.out.println("test");
    }
}

class Solution_t面试题_1626 {
    public int calculate(String s) {
        String t = f(s);
        return cal(t);
    }

    String f(String s) {
        // 中缀表达式转后缀表达式
        Stack<Character> op = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    while (!op.isEmpty()) {
                        res.append(op.pop());
                    }
                    op.push(ch);
                    break;
                case '*':
                case '/':
                    while (!op.isEmpty() && op.peek() != '+' && op.peek() != '-') {
                        res.append(op.pop());
                    }
                    op.push(ch);
                    break;
                case ' ':
                    break;
                default:
                    res.append(ch);
                    break;
            }
        }
        while (!op.isEmpty()) {
            res.append(op.pop());
        }
        return res.toString();
    }

    int cal(String s) {
        // 后缀表达式求值
        Stack<Integer> digit = new Stack<>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+') {
                int num2 = digit.pop();
                int num1 = digit.pop();
                digit.push(num1 + num2);
            } else if (ch == '-') {
                int num2 = digit.pop();
                int num1 = digit.pop();
                digit.push(num1 - num2);
            } else if (ch == '*') {
                int num2 = digit.pop();
                int num1 = digit.pop();
                digit.push(num1 * num2);
            } else if (ch == '/') {
                int num2 = digit.pop();
                int num1 = digit.pop();
                digit.push(num1 / num2);
            } else {
                digit.push(ch - '0');
            }
        }
        return digit.pop();
    }
}