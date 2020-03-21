package Array.xor;

/**
 * https://www.cnblogs.com/youxin/p/3349834.html
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class FindTwoNumbersThatOnlyAppearOnce {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 1223, 3485948, 4, 4, 5, 5};
        int[] ints = find(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * from right to left ,find the first 1 position of a binary number
     * eg 2 -> 2 8 -> 4
     *
     * @param i
     * @return
     */
    public static int findPos(int i) {
        int idx = 1;
        while ((i & 1) != 1) {
            idx++;
            i = i >> 1;
        }
        return idx;
    }

    public static int[] find(int[] arr) {
        int xor = 0;
        for (int i : arr) {
            xor = xor ^ i;
        }
        int pos = findPos(xor) - 1;
        int number = 1 << pos;
        int first = 0;
        for (int i : arr) {
            if ((i & number) == number) {
                first = first ^ i;
            }
        }
        int second = xor ^ first;
        return new int[]{first, second};
    }

}
