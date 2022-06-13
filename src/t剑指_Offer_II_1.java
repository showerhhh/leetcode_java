public class t剑指_Offer_II_1 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_II_1 {
    public int divide(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }

        int sign;
        if ((a > 0) ^ (b > 0)) {
            sign = -1;
        } else {
            sign = 1;
        }
        int res = div(-Math.abs(a), -Math.abs(b));
        if (sign == 1) {
            return res;
        } else {
            return -res;
        }
    }

    int div(int a, int b) {
        int count = 0;
        while (a <= b) {
            a -= b;
            count++;
        }
        return count;
    }
}