public class t28 {
    public static void main(String[] args) {
        Solution_t28 solution = new Solution_t28();
        String haystack = "hello";
        String needle = "ll";
        System.out.println(solution.strStr(haystack, needle));
    }
}

class Solution_t28 {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}