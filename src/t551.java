public class t551 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t551 {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                countL++;
                if (countL >= 3) {
                    return false;
                }
            } else {
                countL = 0;
                if (ch == 'A') {
                    countA++;
                }
            }
        }
        return countA < 2;
    }
}