import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class t17 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t17 {
    ArrayList<String> res = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return res;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtracking(0, new StringBuilder(), digits);
        return res;
    }

    void backtracking(int k, StringBuilder list, String digits) {
        if (list.length() == digits.length()) {
            res.add(list.toString());
            return;
        }
        for (char ch : map.get(digits.charAt(k)).toCharArray()) {
            list.append(ch);
            backtracking(k + 1, list, digits);
            list.deleteCharAt(list.length() - 1);
        }
    }
}