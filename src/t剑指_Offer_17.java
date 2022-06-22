import java.util.ArrayList;
import java.util.List;

public class t剑指_Offer_17 {
    public static void main(String[] args) {
        Solution_t剑指_Offer_17 solution = new Solution_t剑指_Offer_17();
        solution.printNumbers(3);
    }
}

class Solution_t剑指_Offer_17 {
    ArrayList<String> res;

    public List<String> printNumbers(int n) {
        // 本题应该是大数问题，用字符串保存
        res = new ArrayList<>();
        backtracking(n, 0, new StringBuilder());
        return res;
    }

    void backtracking(int n, int idx, StringBuilder builder) {
        if (idx == n) {
            StringBuilder copy = new StringBuilder(builder);
            while (copy.length() != 0 && copy.charAt(0) == '0') {
                copy.deleteCharAt(0);
            }
            if (copy.length() != 0) {
                res.add(copy.toString());
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            char ch = (char) ('0' + i);
            builder.append(ch);
            backtracking(n, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}