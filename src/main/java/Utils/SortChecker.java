package Utils;

import java.util.Arrays;

public class SortChecker {
    public static void main(String[] args) {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            try {
                SortUtils.quickSort(arr1);
            } catch (Throwable e) {
                printArray(arr3);
                e.printStackTrace();
                return;
            }
            rightMethod(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "error----");
        int[] arr = generateRandomArray(size, value);
        printArray(arr);
        SortUtils.quickSort(arr);
        printArray(arr);

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int size, int value) {
        /*
         * Math.random() -> double [0,1)
         * (int) ((size + 1) * Math.random()) -> [0,size]整数
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
    public static int[] copyArray(int[] arr) {
        if (arr == null)
            return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if (arr1 == null && arr2 == null)
            return true;
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static void printArray(int[] arr) {
        if (arr == null)
            return;
        System.out.println(Arrays.toString(arr));
    }


}
