public class t461 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t461 {
    public int hammingDistance(int x, int y) {
        int t = x ^ y;
        int count = 0;
        while (t != 0) {
            if (t % 2 == 1) {
                count++;
            }
            t /= 2;
        }
        return count;
    }
}