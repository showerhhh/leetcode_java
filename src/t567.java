import java.util.HashMap;
import java.util.Map;

public class t567 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> s1_map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            s1_map.put(ch, s1_map.getOrDefault(ch, 0) + 1);
        }

        // window初始化
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s2.charAt(i);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
        }
        if (check(s1_map, window)) {
            return true;
        }
        // 滑动窗口
        int start = 0;
        int end = s1.length();  // 左闭右开区间
        while (end < s2.length()) {
            // 先移动滑动窗口
            window.put(s2.charAt(end), window.getOrDefault(s2.charAt(end), 0) + 1);
            window.put(s2.charAt(start), window.get(s2.charAt(start)) - 1);
            start++;
            end++;
            // 再检查
            if (check(s1_map, window)) {
                return true;
            }
        }
        return false;
    }

    boolean check(HashMap<Character, Integer> s1_map, HashMap<Character, Integer> window) {
        // 判断两个哈希表是否相等
        for (Map.Entry<Character, Integer> entry : window.entrySet()) {
            char k = entry.getKey();
            int v = entry.getValue();
            if (s1_map.getOrDefault(k, 0) != v) {
                return false;
            }
        }
        for (Map.Entry<Character, Integer> entry : s1_map.entrySet()) {
            char k = entry.getKey();
            int v = entry.getValue();
            if (window.getOrDefault(k, 0) != v) {
                return false;
            }
        }
        return true;
    }
}