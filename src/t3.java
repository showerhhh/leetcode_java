import java.util.HashMap;
import java.util.HashSet;

public class t3 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t3 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0, r = 0, maxLength = 0;
        while (r < s.length()) {
            while (set.contains(s.charAt(r)) && l < r) {  // 当窗口不满足题意时，l指针左移
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            r++;
            maxLength = Math.max(maxLength, r - l);  // 判断并记录
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring_2(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int l = 0, r = 0, maxLength = 0;
        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            r++;
            while (check(map) && l < r) {  // 当窗口不满足题意时，l指针左移
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            maxLength = Math.max(maxLength, r - l);  // 判断并记录
        }
        return maxLength;
    }

    boolean check(HashMap<Character, Integer> map) {
        for (int count : map.values()) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}