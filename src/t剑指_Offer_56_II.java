public class t剑指_Offer_56_II {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_56_II {
    public int singleNumber(int[] nums) {
        // 数组counts记录所有数字的各二进制位的1的出现次数。
        int[] counts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                counts[i] += num & 1;
                num >>>= 1;
            }
        }
        // 将counts各元素对3求余，则结果为 “只出现一次的数字” 的各二进制位。
        for (int i = 0; i < 32; i++) {
            counts[i] %= 3;
        }
        // 将counts数组转化为数字。
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i];
        }
        return res;
    }
}