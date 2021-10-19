public class t367 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t367 {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if ((long) mid * mid > num) {
                right = mid - 1;
            } else if ((long) mid * mid < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}