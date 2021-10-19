public class t69 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t69 {
    public int mySqrt(int x) {
        int left = 1, right = x, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if ((long) mid * mid > x) {
                right = mid - 1;
            } else if ((long) mid * mid < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}