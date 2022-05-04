public class t50 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t50 {
    public double myPow(double x, int n) {
        long N = n;  // 测试用例中，n有int的负最大值，直接-n会超出int的范围。
        if (N == 0) {
            return 1;
        } else if (N > 0) {
            return pow(x, N);
        } else {
            return 1 / pow(x, -N);
        }
    }

    double pow(double x, long n) {
        // n为正整数
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            double t = pow(x, n / 2);
            return t * t;
        } else {
            double t = pow(x, n / 2);
            return x * t * t;
        }
    }

    double pow_v2(double x, long n) {
        // n为正整数
        double res = 1;
        double contri = x;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= contri;
            }
            contri *= contri;
            n /= 2;
        }
        return res;
    }
}