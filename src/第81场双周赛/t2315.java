package 第81场双周赛;

public class t2315 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t2315 {
    public int countAsterisks(String s) {
        int countl = 0;
        int res = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '|') {
                countl++;
            }
            if (countl % 2 == 0 && ch == '*') {
                res++;
            }
        }
        return res;
    }
}