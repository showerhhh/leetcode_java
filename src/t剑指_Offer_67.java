public class t剑指_Offer_67 {
    public static void main(String[] args) {
        Solution_t剑指_Offer_67 solution = new Solution_t剑指_Offer_67();
        String str = "-91283472332";
        System.out.println(solution.strToInt(str));
    }
}

class Solution_t剑指_Offer_67 {
    public int strToInt(String str) {
        // 处理前后空格
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        // 处理符号
        int sign = 1;
        if (str.charAt(0) == '+') {
            sign = 1;
            str = str.substring(1);
        } else if (str.charAt(0) == '-') {
            sign = -1;
            str = str.substring(1);
        }
        if (str.length() == 0) {
            return 0;
        }
        // 获取数字部分
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            i++;
        }
        str = str.substring(0, i);
        if (str.length() == 0) {
            return 0;
        }
        // 转换数字部分，因为数字有可能超出范围，所以不能求出来再判断，而应该边求边判断
        long sum = 0;
        long MAX = (long) Math.pow(2, 31) - 1;
        long MIN = -(long) Math.pow(2, 31);
        if (sign == 1) {
            for (char ch : str.toCharArray()) {
                sum = sum * 10 + (ch - '0');
                if (sum >= MAX) {
                    return (int) MAX;
                }
            }
        } else {
            for (char ch : str.toCharArray()) {
                sum = sum * 10 - (ch - '0');
                if (sum <= MIN) {
                    return (int) MIN;
                }
            }
        }
        return (int) sum;
    }
}