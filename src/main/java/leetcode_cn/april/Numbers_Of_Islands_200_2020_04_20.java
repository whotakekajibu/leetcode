package leetcode_cn.april;

/**
 * @Description
 * @Date 2020/4/20 20:40
 **/
public class Numbers_Of_Islands_200_2020_04_20 {
    public static void main(String[] args) {
/*        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };*/

/*        char[][] grid = {

                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };*/
        char[][] grid = {
                {'0', '1', '0'},
                {'1', '0', '1'},
                {'0', '1', '0'},
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void dfs(char[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        if (grid[x][y] == '1') {
            dfs(grid, x + 1, y, visited);
            dfs(grid, x - 1, y, visited);
            dfs(grid, x, y + 1, visited);
            dfs(grid, x, y - 1, visited);
        }
    }
}
