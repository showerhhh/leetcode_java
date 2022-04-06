import java.util.ArrayList;
import java.util.List;

public class t93 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t93 {
    ArrayList<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, new ArrayList<>());
        return res;
    }

    void backtracking(String s, int idx, ArrayList<String> list) {
        if (list.size() > 4) {
            return;
        }
        if (list.size() == 4) {
            if (idx == s.length()) {
                res.add(String.join(".", list));
                return;
            } else {
                return;
            }
        }
        if (list.size() < 4) {
            if (idx == s.length()) {
                return;
            }
        }
        for (int i = idx; i < s.length(); i++) {
            if (check(s.substring(idx, i + 1))) {
                list.add(s.substring(idx, i + 1));
                backtracking(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    boolean check(String t) {
        // 判断t是否为IP中合法的数字
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (ch > '9' || ch < '0') {
                return false;
            }
        }
        if (t.length() >= 2 && t.charAt(0) == '0') {
            return false;
        }
        int x = 0;
        for (int i = 0; i < t.length(); i++) {
            int y = t.charAt(i) - '0';
            x = x * 10 + y;
        }
        if (x > 255 || x < 0) {
            return false;
        }
        return true;
    }
}