public class t面试题_0105 {
    public static void main(String[] args) {
        Solution_t面试题_0105 solution = new Solution_t面试题_0105();
        solution.oneEditAway("pale", "ple");
    }
}

class Solution_t面试题_0105 {
    public boolean oneEditAway(String first, String second) {
        int f = first.length(), s = second.length();
        if (f - s > 1 || s - f > 1) {
            return false;
        }
        int i = 0, j = 0;
        int count = 0;
        while (i < f && j < s) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else {
                count++;
                if (count > 1) {
                    return false;
                }
                if (f > s) {
                    i++;
                } else if (f < s) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return true;
    }
}