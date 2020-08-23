package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Date 2019/12/1 21:14
 **/
public class Valid_Sudoku_20191201 {
    public static void main(String[] args) {
        Valid_Sudoku_20191201 valid = new Valid_Sudoku_20191201();
        char[][] board = {
                {'5', '3', '.',   '.', '7', '.',   '.', '.', '.'},
                {'6', '.', '.',   '1', '9', '5',   '.', '.', '.'},
                {'.', '9', '8',   '.', '.', '.',   '.', '6', '.'},

                {'8', '.', '.',   '.', '6', '.',   '.', '.', '3'},
                {'4', '.', '.',   '8', '.', '3',   '.', '.', '1'},
                {'7', '.', '.',   '.', '2', '.',   '.', '.', '6'},

                {'.', '6', '.',   '.', '.', '.',   '2', '8', '.'},
                {'.', '.', '.',   '4', '1', '9',   '.', '.', '5'},
                {'.', '.', '.',   '.', '8', '.',   '.', '7', '9'}
        };
        System.out.println(valid.isValidSudoku(board));
    }


    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('.' != board[i][j]) {
                    String key = getKey(i, j, Character.getNumericValue(board[i][j]));
                    if (set.contains(key) || !valid(i, j, board[i][j], board)) {
                        return false;
                    }
                    set.add(key);
                }
            }
        }
        return true;
    }

    String getKey(int x, int y, int val) {
        int area = getArea(x, y);
        String key = val + "_" + area;
        return key;
    }

    int getArea(int x, int y) {
        x /= 3;
        y /= 3;
        return x * 3 + y + 1;
    }

    boolean valid(int x, int y, char val, char[][] board) {
        if (x == 0 && y == 0 || x == 1 && y == 2) {
            System.out.println();
        }
        int idx = 0;
        while (idx < board.length) {
            if (y != idx && board[x][idx] == val || idx != x && board[idx][y] == val) {
                return false;
            }
            idx++;
        }
        return true;
    }
}
