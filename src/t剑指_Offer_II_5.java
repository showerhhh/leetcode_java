import java.util.HashSet;

public class t剑指_Offer_II_5 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_II_5 {
    public int maxProduct(String[] words) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                set.clear();
                boolean flag = false;
                for (char ch : words[i].toCharArray()) {
                    set.add(ch);
                }
                for (char ch : words[j].toCharArray()) {
                    if (set.contains(ch)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    maxLength = Math.max(maxLength, words[i].length() * words[j].length());
                }
            }
        }
        return maxLength;
    }
}