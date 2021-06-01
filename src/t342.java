public class t342 {
}

class Solution_t342 {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }
}