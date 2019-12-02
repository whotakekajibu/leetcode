package recursive.backtracking.sudoku_resolver;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2019/11/30 23:50
 **/
public class Sudoku_20191130_v1 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        print2DArray(board);
        System.out.println("--------------------------------");
        sudoku(board);
        print2DArray(board);
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
