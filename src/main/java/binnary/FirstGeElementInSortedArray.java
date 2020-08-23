package binnary;

import Utils.Utils;
import checkers.BinaryChecker;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description
 * @Date 2020/6/14 21:33
 **/
public class FirstGeElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {10, 24, 31, 44, 44, 66, 85};
        int target = 8;
//        System.out.println(firstGeElement(arr, target));
//        System.out.println(BinaryChecker.findTheFirstGe(arr, target));
        check();
    }

    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        Arrays.binarySearch(arr,target);
        int l = 0, r = arr.length - 1;
//        Utils.printOneDimensionalArray(arr);
//        System.out.println("target is :" + target);
        while (l <= r) {
            int mid = (r + l) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                if (mid > 0 && arr[mid - 1] < target) {
                    return arr[mid];
                } else if (mid == 0) {
                    return arr[0];
                }
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void singleCheck() {
        Random random = new Random();
        int len = random.nextInt(10);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int ran = random.nextInt(100);
            arr[i] = ran;
        }
        int target = random.nextInt(100);
        int theFirstGe = BinaryChecker.findTheFirstGe(arr, target);
        int ansWer = binarySearch(arr, target);
        if (theFirstGe != ansWer) {
            Utils.printOneDimensionalArray(arr);
            System.out.println("target is :" + target + " checker answer is :" + theFirstGe + " your answer is:" + ansWer);
            throw new RuntimeException("答案错误");
        }
    }

    public static void check() {
        int times = 100000;
        for (int i = 0; i < times; i++) {
            singleCheck();
            System.out.println("times :" + i);
        }
        System.out.println("核对" + times + "次完毕，没有发现错误！！");
    }
}
