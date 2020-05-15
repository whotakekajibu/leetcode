package Array;

/**
 * @Description
 * @Date 2020/4/5 19:56
 **/
public class Plus_one {
    public static void main(String[] args) {
        Plus_one po = new Plus_one();
        for (int i : po.plusOne(new int[]{9, 9, 9})) {
            System.out.print(i);
        }
    }

    public int[] plusOne(int[] arr) {
        return plus(arr, arr.length - 1, 1);
    }

    public int[] plus(int[] arr, int idx, int carry) {
        if (idx == 0) {
            int re = arr[0] + carry;
            if (re > 9) {
                int[] res = new int[arr.length + 1];
                res[0] = 1;
                arr[0] = re % 10;
                copy(res, arr, 2);
                return res;
            } else {
                arr[0] += carry;
                return arr;
            }
        }
        int cur = carry + arr[idx];
        if (cur > 9) {
            arr[idx] = cur % 10;
            return plus(arr, idx - 1, 1);
        }
        arr[idx] = cur;
        return plus(arr, idx - 1, 0);
    }

    public void copy(int[] a, int[] b, int i) {
        for (int k = i; k < a.length; k++) {
            a[k] = b[k - i];
        }
    }
}
