import java.util.ArrayList;
import java.util.List;

public class t131 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t131 {
    ArrayList<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0, new ArrayList<>());
        return res;
    }

    void backtracking(String s, int idx, ArrayList<String> list) {
        if (idx >= s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (check(s, idx, i)) {
                list.add(s.substring(idx, i + 1));
                backtracking(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    boolean check(String s, int start, int end) {
        // 判断s[start~end]是否为回文字符串
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}