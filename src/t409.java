import java.util.HashMap;
import java.util.Map;

public class t409 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        boolean flag = false;  // 是否有奇数
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            if (v % 2 == 0) {
                count += v;
            } else {
                count += v - 1;
                flag = true;
            }
        }
        if (flag) {
            count++;
        }
        return count;
    }
}