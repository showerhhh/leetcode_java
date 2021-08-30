import java.util.Random;

public class t528 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t528 {
    int[] w;
    int sum;
    Random rand = new Random();

    public Solution_t528(int[] w) {
        this.w = w;
        for (int x : w) {
            sum += x;
        }
    }

    public int pickIndex() {
        int r = rand.nextInt(sum);
        int p = 0;
        int i = 0;
        while (p <= r) {
            p += w[i];
            i++;
        }
        return i - 1;
    }
}