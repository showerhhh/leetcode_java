import java.util.HashMap;
import java.util.Map;

public class t424 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t424 {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        while (right < s.length() - 1) {
            right++;
            char ch_r = s.charAt(right);
            map.put(ch_r, map.getOrDefault(ch_r, 0) + 1);
            if (!check(map, k, left, right)) {
                // 不能继续扩大滑动窗口，则left++（相当于移动了滑动窗口）
                char ch_l = s.charAt(left);
                map.put(ch_l, map.get(ch_l) - 1);
                left++;
            }
        }
        return right - left + 1;
    }

    boolean check(HashMap<Character, Integer> map, int k, int left, int right) {
        // 检查map中个数最多的字母的数目+k是否大于等于滑动窗口大小
        int max = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            if (v > max) {
                max = v;
            }
        }
        return max + k >= right - left + 1;
    }
}