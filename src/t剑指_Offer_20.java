public class t剑指_Offer_20 {
    public static void main(String[] args) {
        Solution_t剑指_Offer_20 solution = new Solution_t剑指_Offer_20();
        String s = "1.";
        solution.isNumber(s);
    }
}

class Solution_t剑指_Offer_20 {
    public boolean isNumber(String s) {
        s = s.trim();
        String[] s_list = s.split("E|e", -1);
        if (s_list.length == 1) {
            return isInt(s_list[0]) || isFloat(s_list[0]);
        } else if (s_list.length == 2) {
            return (isInt(s_list[0]) || isFloat(s_list[0])) && isInt(s_list[1]);
        } else {
            return false;
        }
    }

    boolean isInt(String s) {
        if (s.equals("")) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        return atLeastOneNums(s);
    }

    boolean isFloat(String s) {
        if (s.equals("")) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        String[] s_list = s.split("\\.", -1);
        if (s_list.length == 2) {
            boolean flag1 = s_list[0].equals("") && atLeastOneNums(s_list[1]);
            boolean flag2 = atLeastOneNums(s_list[0]) && s_list[1].equals("");
            boolean flag3 = atLeastOneNums(s_list[0]) && atLeastOneNums(s_list[1]);
            return flag1 || flag2 || flag3;
        } else {
            return false;
        }
    }

    boolean atLeastOneNums(String s) {
        if (s.equals("")) {
            return false;
        }
        for (char ch : s.toCharArray()) {
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }
}