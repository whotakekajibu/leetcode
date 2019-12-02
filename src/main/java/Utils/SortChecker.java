package Utils;

import java.util.Arrays;

public class SortChecker {

    public static void main(String[] args) {
        int i = 1, b = 0;
        try {
            System.out.println(i / b);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("wtf");
    }

    public static void Check(Sort sort) {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        for (int i = 0; i < testTime; i++) {
            int[] forTesterSort = generateRandomArray(size, value);
            int[] absoluteRight = copyArray(forTesterSort);
            int[] original = copyArray(forTesterSort);
            try {
                sort.sort(forTesterSort);
            } catch (Throwable e) {
                System.out.println("print the test array");
                printArray(original);
                e.printStackTrace();
                return;
            }
            rightMethod(absoluteRight);
            if (!isEqual(forTesterSort, absoluteRight)) {
                System.out.println("the test array before sort");
                printArray(original);
                System.out.println("the test array after sort");
                printArray(forTesterSort);
                System.out.println("and what the arry should look like");
                printArray(absoluteRight);
                return;
            }
        }
        System.out.println("Nice! you have passed all the test case! Now  give your example");
        int[] arr = generateRandomArray(size, value);
        printArray(arr);
        sort.sort(arr);
        printArray(arr);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    private static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    private static int[] generateRandomArray(int size, int value) {
        /*
         * MathUtils.random() -> double [0,1)
         * (int) ((size + 1) * MathUtils.random()) -> [0,size]整数
         * */
        // 生成长度随机[0, size]的数组
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // 一个随机数减去另一个随机数，生成[-value, value]的随机数
            arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }

    // for test, copy a array
    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    private static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        System.out.println(Arrays.toString(arr));
    }

    public interface Sort {
        public void sort(int[] arr);
    }


}
