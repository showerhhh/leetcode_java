package 第250场周赛;

import java.util.HashSet;

public class t5161 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t5161 {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }
        int countBad = 0;
        String[] list = text.split(" ");
        for (int i = 0; i < list.length; i++) {
            String s = list[i];
            for (int j = 0; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    countBad++;
                    break;
                }
            }
        }
        return list.length - countBad;
    }
}