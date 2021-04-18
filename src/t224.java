import java.util.ArrayList;

public class t224 {
    public static void main(String[] args) {
        String s = "1+1+1";
        Solution_t224 solution = new Solution_t224();
        System.out.println(solution.calculate(s));
    }
}

class Solution_t224 {
    public int calculate(String s) {
        //String[] tokens = {"(", "(", "10", "*", "(", "6", "/", "(", "(", "9", "+", "3", ")", "*", "-11", ")", ")", ")", "+", "17", ")", "+", "5"};
        String[] tokens = process(s);
        tokens = zhongToHou(tokens);
        return houToZhi(tokens);
    }

    String[] process(String s) {
        ArrayList<String> result = new ArrayList<String>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                //去掉空格
                i++;
                continue;
            }

            if (!Character.isDigit(ch)) {
                result.add(String.valueOf(ch));
                i++;
            } else {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                result.add(s.substring(start, i));
            }
        }

        //将ArrayList转成String[]
        String[] tmp = new String[result.size()];
        for (int j = 0; j < result.size(); j++) {
            tmp[j] = result.get(j);
        }
        return tmp;
    }

    String[] zhongToHou(String[] tokens) {
        ArrayList<String> operator = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            switch (t) {
                case "(": {
                    //处理(
                    operator.add(t);
                    break;
                }
                case ")": {
                    //处理)
                    while (!operator.isEmpty()) {
                        String top = operator.get(operator.size() - 1);
                        if (top.equals("(")) {
                            break;
                        }
                        result.add(operator.remove(operator.size() - 1));
                    }
                    operator.remove(operator.size() - 1);  //删去'('
                    break;
                }
                case "+":
                case "-": {
                    //处理+-
                    while (!operator.isEmpty()) {
                        String top = operator.get(operator.size() - 1);
                        if (top.equals("(")) {
                            break;
                        }
                        result.add(operator.remove(operator.size() - 1));
                    }
                    operator.add(t);
                    break;
                }
                case "*":
                case "/": {
                    //处理*/
                    while (!operator.isEmpty()) {
                        String top = operator.get(operator.size() - 1);
                        if (top.equals("(") || top.equals("+") || top.equals("-")) {
                            break;
                        }
                        result.add(operator.remove(operator.size() - 1));
                    }
                    operator.add(t);
                    break;
                }
                default: {
                    //处理数字
                    result.add(t);
                    break;
                }
            }
        }
        while (!operator.isEmpty()) {
            result.add(operator.remove(operator.size() - 1));
        }

        //将ArrayList转成String[]
        String[] tmp = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            tmp[i] = result.get(i);
        }
        return tmp;
    }

    int houToZhi(String[] tokens) {
        ArrayList<Integer> stack = new ArrayList<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                stack.add(Integer.parseInt(tokens[i]));
            } catch (NumberFormatException e) {
                int right = stack.remove(stack.size() - 1);
                int left = stack.remove(stack.size() - 1);
                switch (tokens[i]) {
                    case "+":
                        stack.add(left + right);
                        break;
                    case "-":
                        stack.add(left - right);
                        break;
                    case "*":
                        stack.add(left * right);
                        break;
                    case "/":
                        stack.add(left / right);
                        break;
                }
            }
        }
        return stack.get(stack.size() - 1);
    }
}