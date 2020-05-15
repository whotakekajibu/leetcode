package Array;

import Utils.Utils;

/**
 * @Description
 * @Date 2020/4/5 23:08
 **/
public class rotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        Utils.printTwoDimensionalArray(matrix);
    }
    public static void rotate(int[][] m) {
        int lx=0,ly=0,rx=m.length-1,ry=m.length-1;
        while(ly<ry){
            rotate(m,lx,ly,rx,ry);
            lx++;
            ly++;
            rx--;
            ry--;
        }
    }
    static void rotate(int[][] m,int lx,int ly,int rx,int ry){
        int cre = ry - ly;
        for(int i = 0;i< cre;i++){
            //store top value
            int tmp = m[lx][ly+i];
            //left value to top
            m[lx][ly+i] = m[rx-i][ly];
            //bottom value to left
            m[rx-i][ly] = m[rx][ry-i];
            //right to bottom
            m[rx][ry-i] = m[lx+i][ry];
            //top value to right
            m[lx+i][ry] = tmp;
            Utils.printTwoDimensionalArray(m);
        }

    }
}
