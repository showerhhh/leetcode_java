public class t剑指_Offer_14_II {
    public static void main(String[] args) {
        int n = 120;
        Solution_t剑指_Offer_14_II solution = new Solution_t剑指_Offer_14_II();
        System.out.println(solution.cuttingRope(n));
    }
}

class Solution_t剑指_Offer_14_II {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3, p = 1000000007;
        long ret = 1;
        int lineNums = n / 3;  // 线段被我们分成以3为大小的小线段个数
        for (int i = 1; i < lineNums; i++)  // 从第一段线段开始验算，3的ret次方是否越界。注意是验算lineNums-1次。
            ret = 3 * ret % p;
        if (b == 0)
            return (int) (ret * 3 % p);  // 刚好被3整数的，要算上前一段
        if (b == 1)
            return (int) (ret * 4 % p);  // 被3整数余1的，要算上前一段
        else {
            return (int) (ret * 6 % p);  // 被3整数余2的，要算上前一段
        }
    }
}