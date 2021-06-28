package 第247场周赛;

public class t5799 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t5799 {
    public long wonderfulSubstrings(String word) {
        long count = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                if (check(word.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean check(String word) {
        int[] char_count = new int[10];
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            char_count[index]++;
        }
        int ow_count = 0;
        for (int i = 0; i < 10; i++) {
            if (char_count[i] % 2 != 0) {
                ow_count++;
            }
        }
        return ow_count <= 1;
    }
}