import java.util.HashMap;

public class t76 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = 0;  // 滑动窗口，左闭右开区间
        int minLength = Integer.MAX_VALUE, minL = 0, minR = 0;
        while (r < s.length()) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) - 1);
            r++;
            while (check(count) && l < r) {  // 当窗口满足题意时，l指针左移
                if (r - l < minLength) {  // 判断并记录
                    minLength = r - l;
                    minL = l;
                    minR = r;
                }
                count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) + 1);
                l++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(minL, minR);
        }
    }

    boolean check(HashMap<Character, Integer> count) {
        // 检查count中的value均<=0
        for (int v : count.values()) {
            if (v > 0) {
                return false;
            }
        }
        return true;
    }
}