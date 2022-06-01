import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class t301 {
    public static void main(String[] args) {
        Solution_t301 solution = new Solution_t301();
        String s = "()())()";
        solution.removeInvalidParentheses(s);
    }
}

class Solution_t301 {
    HashSet<String> res;
    int maxLength;
    int maxPair;

    public List<String> removeInvalidParentheses(String s) {
        res = new HashSet<>();
        res.add("");
        maxLength = 0;
        int countL = 0, countR = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                countL++;
            } else if (ch == ')') {
                countR++;
            }
        }
        maxPair = Math.min(countL, countR);
        backtracking(s, 0, 0, 0, new StringBuilder());
        return new ArrayList<>(res);
    }

    void backtracking(String s, int idx, int l, int r, StringBuilder b) {
        if (l > maxPair || r > l) {
            return;
        }
        if (l == r) {
            if (b.length() > maxLength) {
                res.clear();
                res.add(b.toString());
                maxLength = b.length();
            } else if (b.length() == maxLength) {
                res.add(b.toString());
            }
        }
        if (idx >= s.length()) {
            return;
        }

        // 选择idx
        char ch = s.charAt(idx);
        if (ch == '(') {
            b.append(ch);
            backtracking(s, idx + 1, l + 1, r, b);
            b.deleteCharAt(b.length() - 1);
        } else if (ch == ')') {
            b.append(ch);
            backtracking(s, idx + 1, l, r + 1, b);
            b.deleteCharAt(b.length() - 1);
        } else {
            b.append(ch);
            backtracking(s, idx + 1, l, r, b);
            b.deleteCharAt(b.length() - 1);
        }
        // 不选择idx
        backtracking(s, idx + 1, l, r, b);
    }
}