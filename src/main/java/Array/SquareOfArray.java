package Array;

public class SquareOfArray {
    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};
        sortedSquares(arr);
    }
    public static int[] sortedSquares(int[] A) {
        int r = A.length-1,tmp=0;
        while(r > 0){
            if(Math.abs(A[r]) > Math.abs(A[0])){
                A[r] *= A[r];
                r--;
            }else{
                tmp = A[r];
                A[r] = A[0];
                A[0] = tmp;
            }
        }
        A[0] *= A[0];
        return A;
    }

}
