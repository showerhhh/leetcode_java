import java.util.HashSet;

public class t36 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] column = new HashSet[9];
        HashSet<Character>[] block = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            column[i] = new HashSet<>();
            block[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }

                if (row[i].contains(ch)) {
                    return false;
                } else {
                    row[i].add(ch);
                }

                if (column[j].contains(ch)) {
                    return false;
                } else {
                    column[j].add(ch);
                }

                int index = (i / 3) * 3 + (j / 3);
                if (block[index].contains(ch)) {
                    return false;
                } else {
                    block[index].add(ch);
                }
            }
        }
        return true;
    }
}