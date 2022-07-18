public class t剑指_Offer_62 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_62 {
    public int lastRemaining(int n, int m) {
        int pos = 0;  // 只剩1个人时，剩下的那个数字下标为0
        // 反推：剩n个人时，剩下的那个数字的下标
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i;
        }
        return pos;
    }
}