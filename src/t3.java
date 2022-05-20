import java.util.HashSet;

public class t3 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int maxLength = 1, left = 0, right = 1;
        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
                right++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}