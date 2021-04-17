import java.util.ArrayList;

public class t71 {
    public static void main(String[] args) {
        Solution_t71 solution = new Solution_t71();
        String path = "/a/./b/../../c/";
        System.out.println(solution.simplifyPath(path));
    }
}

class Solution_t71 {
    public String simplifyPath(String path) {
        ArrayList<String> stack = new ArrayList<String>();
        String[] list = path.split("/");
        for (int i = 0; i < list.length; i++) {
            if (list[i].isEmpty()) {
                continue;//Java的String.split()会产生""
            }

            if (list[i].equals(".")) {
                continue;
            } else if (list[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.remove(stack.size() - 1);
                } else {
                    continue;
                }
            } else {
                stack.add(list[i]);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder tmp = new StringBuilder();
        tmp.append("/");
        for (int i = 0; i < stack.size(); i++) {
            tmp.append(stack.get(i));
            tmp.append("/");
        }
        tmp.deleteCharAt(tmp.length() - 1);
        return tmp.toString();
    }
}