package leetcode_cn.april;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * @Description
 * @Date 2020/4/8 21:59
 **/
public class Robot_range_2020_0408 {
    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
    }

    public static int movingCount(int m, int n, int k) {
        int[][] map = new int[m][n];
        return helper(map, 3, 1, 0);
    }

    public static int helper(int[][] map, int x, int y, int k) {
        int bitSum = getBitSum(x) + getBitSum(y);
        if (bitSum > k || x >= map.length || x < 0 || y < 0 || y >= map[0].length || map[x][y] == 1) {
            return 0;
        }
        map[x][y] = 1;
        int left = helper(map, x, y - 1, k);
        int right = helper(map, x, y + 1, k);
        int top = helper(map, x - 1, y, k);
        int bottom = helper(map, x + 1, y, k);
        return left + right + top + bottom + 1;
    }

    public static int getBitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }


}
