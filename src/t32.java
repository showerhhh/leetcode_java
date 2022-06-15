public class t32 {
}

class Solution_t32 {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int leftCount = 0, rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }

            if (leftCount == rightCount) {
                maxLength = Math.max(maxLength, leftCount + rightCount);
            } else if (leftCount < rightCount) {
                leftCount = 0;
                rightCount = 0;
            }
        }

        leftCount = 0;
        rightCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }

            if (leftCount == rightCount) {
                maxLength = Math.max(maxLength, leftCount + rightCount);
            } else if (leftCount > rightCount) {
                leftCount = 0;
                rightCount = 0;
            }
        }

        return maxLength;
    }
}