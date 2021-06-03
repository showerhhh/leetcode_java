public class t剑指_Offer_14_I {
    public static void main(String[] args) {
        int n = 7;
        Solution_t剑指_Offer_14_I solution = new Solution_t剑指_Offer_14_I();
        System.out.println(solution.cuttingRope(n));
    }
}

class Solution_t剑指_Offer_14_I {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        } else if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        } else {
            return (int) Math.pow(3, a) * 2;
        }
    }
}