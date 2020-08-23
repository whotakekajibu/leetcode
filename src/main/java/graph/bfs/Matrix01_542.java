package graph.bfs;

import Utils.Utils;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Date 2020/4/15 22:18
 **/
public class Matrix01_542 {
    public static void main(String[] args) {
        int[][] matrix =   {{1, 0, 0},
                            {0, 1, 0},
                            {1, 1, 1}};
        Utils.printTwoDimensionalArray(updateMatrix(matrix));
    }

    public static int[][] updateMatrix(int[][] matrix) {
        Deque<Coordinate> q = new LinkedList<>();
        int[][] visited = new int[matrix.length][matrix[0].length];
        int[][] ans = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new Coordinate(i, j));
                    visited[i][j] = 1;
                }
            }
        }
        int step = 0;
        List<Coordinate> list = Arrays.asList(new Coordinate(-1, 0), new Coordinate(1, 0), new Coordinate(0, 1), new Coordinate(0, -1));
        while (!q.isEmpty()) {
            int len = q.size();
            while (len > 0) {
                len--;
                Coordinate poll = q.poll();
                int x = poll.x, y = poll.y;
                if (matrix[x][y] == 1) {
                    ans[x][y] = step;
                }
                for (Coordinate coordinate : list) {
                    int nx = x + coordinate.x, ny =  y + coordinate.y;
                    if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length || visited[nx][ny] == 1) {
                        continue;
                    }
                    q.offer(new Coordinate(nx, ny));
                    visited[nx][ny] = 1;
                }
            }
            step++;
        }
        return ans;
    }

    static class Coordinate {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[ x:" + x + "; y:" + y + "]";
        }
    }
}
