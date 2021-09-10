import java.util.Arrays;

public class t面试题_1606 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1606 {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        long res = Long.MAX_VALUE;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                res = Math.min(res, (long) a[i] - (long) b[j]);
                j++;
            } else if (a[i] < b[j]) {
                res = Math.min(res, (long) b[j] - (long) a[i]);
                i++;
            } else {
                return 0;
            }
        }
        return (int) res;
    }
}