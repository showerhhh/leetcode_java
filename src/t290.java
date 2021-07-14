import java.util.HashMap;

public class t290 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t290 {
    public boolean wordPattern(String pattern, String s) {
        String[] list = s.split(" ");
        if (pattern.length() != list.length) {
            return false;
        }
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char x = pattern.charAt(i);
            String y = list[i];

            if (!map1.containsKey(x)) {
                map1.put(x, y);
            } else {
                if (!map1.get(x).equals(y)) {
                    return false;
                }
            }

            if (!map2.containsKey(y)) {
                map2.put(y, x);
            } else {
                if (map2.get(y) != x) {
                    return false;
                }
            }
        }
        return true;
    }
}