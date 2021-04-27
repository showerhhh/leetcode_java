public class t880 {
    public static void main(String[] args) {
        String S = "a2345678999999999999999";
        int K = 1;
        Solution_t880 solution = new Solution_t880();
        System.out.println(solution.decodeAtIndex(S, K));
    }
}

class Solution_t880 {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        int N = S.length();

        // Find size = length of decoded string
        for (int i = 0; i < N; ++i) {
            char c = S.charAt(i);
            if (Character.isDigit(c))
                size *= c - '0';
            else
                size++;
        }

        for (int i = N - 1; i >= 0; --i) {
            char c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c))
                return Character.toString(c);

            if (Character.isDigit(c))
                size /= c - '0';
            else
                size--;
        }
        return null;
    }
}