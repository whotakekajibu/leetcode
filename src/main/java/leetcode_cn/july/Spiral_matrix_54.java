package leetcode_cn.july;

import Utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Date 2020/6/5 20:17
 **/
public class Spiral_matrix_54 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers = spiralOrder(matrix);
        integers.forEach(System.out::println);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0){
            return res;
        }
        int x1 = 0, y1 = 0, x2 = matrix.length - 1, y2 = matrix[0].length - 1;
        while(x1 <= x2 && y1 <= y2){
            circle(x1,y1,x2,y2,matrix,res);
            x1++;
            y1++;
            x2--;
            y2--;
        }
        return res;
    }

    public static void circle(int x1,int y1,int x2, int y2,int[][] matrix,List<Integer> res){
        if(x1 == x2){
            while(y1 <= y2){
                res.add(matrix[x1][y1]);
                y1++;
            }
            return;
        }
        if(y1 == y2){
            while(x1 <= x2){
                res.add(matrix[x1][y1]);
                x1++;
            }
            return;
        }
        int dx=x1,dy=y1;
        while(y1 <= y2){
            res.add(matrix[x1][y1]);
            y1++;
        }
        x1++;
        while(x1 <= x2){
            res.add(matrix[x1][y2]);
            x1++;
        }
        y2--;
        while(y2 >= dy){
            res.add(matrix[x2][y2]);
            y2--;
        }
        x2--;
        while(x2 > dx){
            res.add(matrix[x2][dy]);
            x2--;
        }
    }
}
