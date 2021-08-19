import java.util.HashSet;

public class t345 {
    public static void main(String[] args) {
        Solution_t345 solution = new Solution_t345();
        solution.reverseVowels("leetcode");
    }
}

class Solution_t345 {
    public String reverseVowels(String s) {
        char[] s_list = s.toCharArray();
        int left = 0;
        int right = s_list.length - 1;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        while (left < right) {
            while (left < right && !set.contains(s_list[left])) {
                left++;
            }
            while (left < right && !set.contains(s_list[right])) {
                right--;
            }
            char tmp = s_list[left];
            s_list[left] = s_list[right];
            s_list[right] = tmp;
            left++;
            right--;
        }
        return String.valueOf(s_list);
    }
}