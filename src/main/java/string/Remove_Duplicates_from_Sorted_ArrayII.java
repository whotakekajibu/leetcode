package string;

public class Remove_Duplicates_from_Sorted_ArrayII {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(arr));
    }

    //
    public static int removeDuplicates(int[] arr) {
        int n = arr.length;
        if (n <= 2) return n;
        int pre = 0, cur = 1, count = 1;
        while (cur < n) {
            if (arr[pre] == arr[cur] && count == 0) ++cur;
            else {
                if (arr[pre] == arr[cur]) {
                    --count;
                } else {
                    count = 1;
                }
                pre++;
                arr[pre] = arr[cur];
                cur++;
            }
        }
        return pre + 1;
    }


}
