public class t面试题_1604 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1604 {
    public String tictactoe(String[] board) {
        if (check(board, 'X')) {
            return "X";
        }
        if (check(board, 'O')) {
            return "O";
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == ' ') {
                    return "Pending";
                }
            }
        }
        return "Draw";
    }

    boolean check(String[] board, char ch) {
        int n = board.length;
        boolean flag;
        // 检查行
        for (int i = 0; i < n; i++) {
            flag = true;
            for (int j = 0; j < n; j++) {
                if (board[i].charAt(j) != ch) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        //检查列
        for (int j = 0; j < n; j++) {
            flag = true;
            for (int i = 0; i < n; i++) {
                if (board[i].charAt(j) != ch) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        // 检查左上-右下对角线
        flag = true;
        for (int i = 0; i < n; i++) {
            if (board[i].charAt(i) != ch) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        }
        // 检查右上-左下对角线
        flag = true;
        for (int i = 0; i < n; i++) {
            if (board[i].charAt(n - 1 - i) != ch) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        }

        return false;
    }
}