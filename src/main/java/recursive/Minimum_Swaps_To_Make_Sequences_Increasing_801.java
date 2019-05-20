package recursive;

public class Minimum_Swaps_To_Make_Sequences_Increasing_801 {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 4};
        int[] B = {1, 2, 3, 7};
        System.out.println(minSwap(A, B));
    }

    public static int minSwap(int[] A, int[] B) {
        return helper(A, B, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    //end with idx
    static int helper(int[] A, int[] B, int idx, int preA, int preB) {
        if (idx == 0) {
//            Character.getNumericValue()
//            Integer.parse
            return 0;
        } else if (idx == A.length - 1) {
            if (preA < A[idx] && preB < B[idx]) {
                return 0;
            }
            if (preA < B[idx] && preB < A[idx]) {
                return 1;
            }
            return Integer.MAX_VALUE;
        } else {
            int notchange = helper(A, B, idx + 1, A[idx], B[idx]);
            int change = Integer.MAX_VALUE;
            if (preA < B[idx] && preB < A[idx]) {
                change = helper(A, B, idx + 1, B[idx], A[idx]);
            }
            return Math.min(notchange, change);
        }
    }

//    void swap(int[] A, int[] B, int i) {
//        int t = A[i];
//        A[i] = B[i];
//        B[i] = t;
//    }
}
