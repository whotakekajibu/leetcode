package xiaomi;

import java.util.*;

public class DifferentSort {
//    public static void main(String[] args) {
//        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5, 6);
//        int[] ar = {1};
//
//        System.out.println(get(ls, 4));
//
//    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] strs = line.split(" ");
            int[] arr = new int[strs.length - 2];
            for (int i = 2; i < strs.length; i++) {
                arr[i - 2] = Integer.parseInt(strs[i]);
            }
            System.out.println(findKthLargest(arr, Integer.parseInt(strs[0])));
        }
    }

    static int get(List<Integer> list, int k) {
        Collections.sort(list, (o1, o2) -> {
            int first = getFactors(o1);
            int second = getFactors(o2);
            if (first > second) {
                return 1;
            } else if (first == second) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 == o2) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        });
        return list.get(k - 1);
    }


    static Map<Integer, Integer> map = new HashMap<>();

    static MyComparator com = new MyComparator();

    public static int getFactors(int n) {
        if (map.containsKey(n)) return map.get(n);
        int count = 0;
        if (n == 0)
            return count;
        else if (n == 1 || n == 2) {
            return ++count;
        } else {
            int l = (int) Math.sqrt(n);
            for (int i = 2; i <= l; i++) {
                if (n % i == 0) {
                    count += 2;
                }
            }
        }
        map.put(n, count + 1);
        return count + 1;
    }


    private static void QuickSort(int[] arr, int begin, int end) {
        if (begin >= end) return;
        int median = partion(arr, begin, end);
        QuickSort(arr, begin, median - 1);
        QuickSort(arr, median + 1, end);
    }

    public static int findKthLargest(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        while (true) {
            int pos = partion(arr, l, r);
            if (pos == k - 1) return arr[pos];
            else if (pos < k - 1) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
        }
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int first = getFactors(o1);
            int second = getFactors(o2);
            if (first > second) {
                return 1;
            } else if (first == second) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 == o2) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }

    //return right boundary
    private static int partion(int[] arr, int begin, int end) {
        int pivot = arr[begin], cur = begin, greater = end + 1;
        while (cur < greater) {
            if (com.compare(arr[cur], pivot) <= 0) {
                cur++;
            } else {
                swap(arr, cur, --greater);
            }
        }
        swap(arr, begin, --cur);
        return cur;
    }

    static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
