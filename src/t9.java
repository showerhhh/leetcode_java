public class t9 {
    public static void main(String[] args) {
        int x = 131;
        Solution_t9 solution = new Solution_t9();
        System.out.println(solution.isPalindrome(x));
    }
}

class Solution_t9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x;
        int y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y == tmp;
    }
}