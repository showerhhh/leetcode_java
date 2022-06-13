public class t剑指_Offer_II_2 {
    public static void main(String[] args) {
        Solution_t剑指_Offer_II_2 solution = new Solution_t剑指_Offer_II_2();
        String a = "11";
        String b = "10";
        solution.addBinary_2(a, b);
    }
}

class Solution_t剑指_Offer_II_2 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < n; i++) {
            if (i < a.length()) {
                carry += a.charAt(a.length() - 1 - i) - '0';
            }
            if (i < b.length()) {
                carry += b.charAt(b.length() - 1 - i) - '0';
            }
            sb.insert(0, carry & 1 + '0');
            carry >>>= 1;
        }
        if (carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    public String addBinary_2(String a, String b) {
        int x = s2i(a);
        int y = s2i(b);
        return i2s(x + y);
    }

    int s2i(String s) {
        int res = 0;
        for (char ch : s.toCharArray()) {
            int t = ch - '0';
            res *= 10;
            res += t;
        }
        return res;
    }

    String i2s(int t) {
        StringBuilder b = new StringBuilder();
        while (t > 0) {
            b.insert(0, t & 1);
            t >>>= 1;
        }
        return b.toString();
    }
}