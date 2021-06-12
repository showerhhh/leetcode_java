public class t剑指_Offer_67 {
    public static void main(String[] args) {
        Solution_t剑指_Offer_67 solution = new Solution_t剑指_Offer_67();
        String str = "-91283472332";
        System.out.println(solution.strToInt(str));
    }
}

class Solution_t剑指_Offer_67 {

    public int strToInt(String str) {
        // i指向第一个非空字符
        int i;
        for (i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                break;
            }
        }

        // 这种""或这种"       "字符串，返回0
        if (i == str.length()) {
            return 0;
        }
        // 第一个非空字符不是数字且不是正负号，返回0
        char tmp = str.charAt(i);
        if (!Character.isDigit(tmp) && tmp != '+' && tmp != '-') {
            return 0;
        }

        // 处理符号位
        char sign = '+';
        if (tmp == '+') {
            sign = '+';
            i++;
            if (i == str.length() || !Character.isDigit(str.charAt(i))) {
                return 0;
            }
        } else if (tmp == '-') {
            sign = '-';
            i++;
            if (i == str.length() || !Character.isDigit(str.charAt(i))) {
                return 0;
            }
        }

        // start指向第一个数字字符，end指向第一个非数字字符
        int start = i;
        for (; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                break;
            }
        }
        int end = i;
        return f(start, end, sign, str);
    }

    int f(int start, int end, char sign, String str) {
        long sum = 0;
        long MAX = (long) Math.pow(2, 31) - 1;
        long MIN = -(long) Math.pow(2, 31);
        if (sign == '+') {
            for (int i = start; i < end; i++) {
                char ch = str.charAt(i);
                sum = sum * 10 + (ch - '0');
                if (sum >= MAX) {
                    return (int) MAX;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                char ch = str.charAt(i);
                sum = sum * 10 - (ch - '0');
                if (sum <= MIN) {
                    return (int) MIN;
                }
            }
        }
        return (int) sum;
    }
}