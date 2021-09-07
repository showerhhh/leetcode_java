public class t1221 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t1221 {
    public int balancedStringSplit(String s) {
        int countL = 0, countR = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                countL++;
            } else {
                countR++;
            }
            if (countL == countR) {
                res++;
                countL = 0;
                countR = 0;
            }
        }
        return res;
    }
}