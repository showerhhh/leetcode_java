import java.util.HashMap;
import java.util.Map;

public class t395 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t395 {
    public int longestSubstring(String s, int k) {
        // 统计s中所有字符出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // 求出现次数小于k的字符
        String reg = "[";
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < k) {
                reg += String.valueOf(entry.getKey());
            }
        }
        reg += "]";

        if (reg.equals("[]")) {
            return s.length();
        }
        String[] list = s.split(reg);
        int maxLength = 0;
        for (int i = 0; i < list.length; i++) {
            int l = longestSubstring(list[i], k);
            if (l > maxLength) {
                maxLength = l;
            }
        }
        return maxLength;
    }
}