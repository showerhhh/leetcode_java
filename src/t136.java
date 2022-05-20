public class t136 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t136 {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        return a;
    }
}