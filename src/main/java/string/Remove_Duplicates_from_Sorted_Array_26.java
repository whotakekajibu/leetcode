package string;

public class Remove_Duplicates_from_Sorted_Array_26 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] arr) {
        if (arr.length <= 1) return arr.length;
        int l = 0, r = 1;
        while (r < arr.length) {
            if (arr[l] != arr[r]) {
                l++;
                arr[l] = arr[r];
            }
            r++;
        }
        return l + 1;
    }
}
