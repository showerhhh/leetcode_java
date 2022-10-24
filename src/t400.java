public class t400 {
    public static void main(String[] args) {
        Solution_t400 solution = new Solution_t400();
        solution.findNthDigit(3);
    }
}

class Solution_t400 {
    public int findNthDigit(int n) {
        int d = 1;
        long count = 9;
        while (n > count * d) {
            n -= count * d;
            d++;
            count *= 10;
        }
        int idx = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + idx / d;
        int offset = idx % d;
        int res = String.valueOf(num).charAt(offset) - '0';
        return res;
    }
}