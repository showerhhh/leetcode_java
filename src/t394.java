import java.util.Stack;

public class t394 {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        Solution_t394 solution = new Solution_t394();
        System.out.println(solution.decodeString(s));
    }
}

class Solution_t394 {
    public String decodeString(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        int multi = 0;
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // 数字
                multi = multi * 10 + (ch - '0');
            } else if (Character.isAlphabetic(ch)) {
                // 字母
                res += ch;
            } else if (ch == '[') {
                // 左括号
                stack1.push(multi);
                stack2.push(res);
                multi = 0;
                res = "";
            } else {
                // 右括号
                StringBuilder tmp = new StringBuilder();
                int t = stack1.pop();
                for (int j = 0; j < t; j++) {
                    tmp.append(res);
                }
                res = stack2.pop() + tmp.toString();
            }
        }
        return res;
    }

    public String decodeString_2(String s) {
        StringBuilder builder = new StringBuilder();
        Stack<Integer> nums_stack = new Stack<>();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                nums_stack.push(count);
                count = 0;
                builder.append(ch);
            } else if (Character.isAlphabetic(ch)) {
                builder.append(ch);
            } else if (Character.isDigit(ch)) {
                count = count * 10 + ch - '0';
            } else if (ch == ']') {
                char x = builder.charAt(builder.length() - 1);
                StringBuilder tmpbuilder = new StringBuilder();  // tmpbuilder保存待重复字符串
                while (x != '[') {
                    tmpbuilder.insert(0, x);
                    builder.deleteCharAt(builder.length() - 1);
                    x = builder.charAt(builder.length() - 1);
                }
                builder.deleteCharAt(builder.length() - 1);
                int t = nums_stack.pop();
                for (int i = 0; i < t; i++) {
                    builder.append(tmpbuilder);
                }
            }
        }
        return builder.toString();
    }
}