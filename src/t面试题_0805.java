public class t面试题_0805 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0805 {
    public int multiply(int A, int B) {
        int x = Math.min(A, B);
        int y = Math.max(A, B);
        return func(x, y);
    }

    int func(int A, int B) {
        if (A == 0) {
            return 0;
        }
        if (A == 1) {
            return B;
        }
        if (A % 2 != 0) {
            return B + func(A - 1, B);
        } else {
            int t = func(A / 2, B);
            return t + t;
        }
    }
}