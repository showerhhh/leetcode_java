import java.util.HashSet;

public class t面试题_0101 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0101 {
    public boolean isUnique(String astr) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            char ch = astr.charAt(i);
            if (set.contains(ch)) {
                return false;
            } else {
                set.add(ch);
            }
        }
        return true;
    }
}