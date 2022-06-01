import java.util.ArrayList;
import java.util.List;

public class t22 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t22 {
    ArrayList<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtracking(n, 0, 0, new StringBuilder());
        return res;
    }

    void backtracking(int n, int leftCount, int rightCount, StringBuilder builder) {
        if (leftCount == n && rightCount == n) {
            res.add(builder.toString());
            return;
        }
        if (leftCount > n || rightCount > leftCount) {
            return;
        }

        // 加左括号
        builder.append('(');
        backtracking(n, leftCount + 1, rightCount, builder);
        builder.deleteCharAt(builder.length() - 1);
        // 加右括号
        builder.append(')');
        backtracking(n, leftCount, rightCount + 1, builder);
        builder.deleteCharAt(builder.length() - 1);
    }
}