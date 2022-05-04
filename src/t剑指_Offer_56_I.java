public class t剑指_Offer_56_I {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_56_I {
    public int[] singleNumbers(int[] nums) {
        // 求所有数字的异或和。
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        // 找出异或和的二进制中为1的一位（此处选择从低位到高位的第一位）
        int idx = 1;
        while ((sum & idx) == 0) {
            idx <<= 1;
        }
        // 将所有数字分为两组，分别求异或和
        int a = 0, b = 0;
        for (int num : nums) {
            if (((num & idx) == 0)) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}