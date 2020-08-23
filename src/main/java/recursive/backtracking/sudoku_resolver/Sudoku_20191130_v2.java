package recursive.backtracking.sudoku_resolver;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Date 2019/11/30 23:50
 **/
public class Sudoku_20191130_v2 {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        /*char[][] board = {
                {'5', '.', '.',    '.', '.', '.',       '.', '.', '.'},
                {'3', '4', '.',    '1', '.', '.',       '.', '.', '7'},
                {'.', '9', '.',    '.', '.', '6',       '.', '.', '.'},

                {'6', '.', '.',    '.', '2', '.',       '.', '.', '9'},
                {'.', '.', '4',    '9', '8', '.',       '1', '.', '.'},
                {'.', '1', '.',    '.', '4', '.',       '.', '.', '.'},

                {'.', '.', '.',    '.', '.', '3',       '.', '2', '6'},
                {'.', '.', '.',    '.', '.', '.',       '8', '.', '.'},
                {'9', '.', '.',    '.', '.', '.',       '3', '4', '.'}};*/
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('.' != board[i][j]) {
                    String key = getKey(i, j, Character.getNumericValue(board[i][j]));
                    if (set.contains(key)) {
                        System.out.println();
                    }
                    set.add(key);
                }
            }
        }
        print2DArray(board);
        System.out.println("--------------------------------");
        sudoku(board);
        print2DArray(board);
    }

    static String getKey(int x, int y, int val) {
        int area = getArea(x, y);
        String key = val + "_" + area;
        return key;
    }

    static int getArea(int x, int y) {
        x /= 3;
        y /= 3;
        return x * 3 + y + 1;
    }

    private static void print2DArray(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void sudoku(char[][] board) {
        System.out.println(helper(board, 0, 0, 0));
    }

    static boolean valid(int x, int y, char val, char[][] board) {
        if (x == 0 && y == 0 || x == 1 && y == 2) {
            System.out.println();
        }
        if (set.contains(getKey(x, y, Character.getNumericValue(val)))) {
            return false;
        }
        int idx = 0;
        while (idx < board.length) {
            if (board[x][idx] == val || board[idx][y] == val) {
                return false;
            }
            idx++;
        }
        return true;
    }

    static boolean helper(char[][] board, int x, int y, int cnt) {
        if (cnt == 81) {
            return true;
        }
        if (x > 8 || y > 8) {
            return false;
        }
        if ('.' == board[x][y]) {
            for (int k = 1; k < 10; k++) {
                if (valid(x, y, Character.forDigit(k, 10), board)) {
                    board[x][y] = Character.forDigit(k, 10);
                    set.add(getKey(x, y, k));
                    if (y < 8) {
                        if (helper(board, x, y + 1, cnt + 1)) {
                            return true;
                        }
                    } else {
                        if (helper(board, x + 1, 0, cnt + 1)) {
                            return true;
                        }
                    }
                    board[x][y] = '.';
                    set.remove(getKey(x, y, k));
                }
            }
        } else {
            if (y < 8) {
                if (helper(board, x, y + 1, cnt + 1)) {
                    return true;
                }
            } else {
                if (helper(board, x + 1, 0, cnt + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

}
