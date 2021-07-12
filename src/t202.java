import java.util.HashSet;

public class t202 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            set.add(n);
            n = f(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    int f(int x) {
        int y = 0;
        while (x != 0) {
            y += Math.pow(x % 10, 2);
            x /= 10;
        }
        return y;
    }
}