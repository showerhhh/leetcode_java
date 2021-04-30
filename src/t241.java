import java.util.ArrayList;
import java.util.List;

public class t241 {
    public static void main(String[] args) {
        String expression = "11";
        Solution_t241 solution = new Solution_t241();
        List<Integer> result = solution.diffWaysToCompute(expression);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

class Solution_t241 {
    public List<Integer> diffWaysToCompute(String expression) {
        //计算字符串expression所有可能的结果
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (expression.length() == 0) {
            return result;
        }

        //考虑是全数字的情况
        int num = 0;
        int index = 0;
        while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
            num = num * 10 + (expression.charAt(index) - '0');
            index++;
        }
        //将全数字的情况直接返回
        if (index == expression.length()) {
            result.add(num);
            return result;
        }

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (!Character.isDigit(ch)) {
                List<Integer> left_result = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right_result = diffWaysToCompute(expression.substring(i + 1));
                for (int x : left_result) {
                    for (int y : right_result) {
                        if (ch == '+') {
                            result.add(x + y);
                        } else if (ch == '-') {
                            result.add(x - y);
                        } else if (ch == '*') {
                            result.add(x * y);
                        }
                    }
                }
            }
        }
        return result;
    }
}
