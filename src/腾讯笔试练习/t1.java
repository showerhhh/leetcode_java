package 腾讯笔试练习;

import java.util.Stack;

public class t1 {
    public static void main(String[] args) {
        Solution_t1 solution = new Solution_t1();
        String str = "3[a]2[bc]";
        solution.compress(str);
    }
}

class Solution_t1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串
     * @return string字符串
     */
    public String compress(String str) {
        StringBuilder builder = new StringBuilder();
        Stack<Integer> nums_stack = new Stack<>();
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '[' || Character.isAlphabetic(ch)) {
                builder.append(ch);
            } else if (Character.isDigit(ch)) {
                count = count * 10 + ch - '0';
            } else if (ch == '|') {
                nums_stack.push(count);
                count = 0;
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