package recursive.tail;

/**
 * @Description
 * @Date 2019/11/22 22:52
 **/
public class Factorial {
    public static void main(String[] args) {
        System.out.println(f(5));
        System.out.println(tail(5,1));
    }

    static int f(int n) {
        if (n <= 2) {
            return n;
        }
        return n * f(n - 1);
    }

    static int tail(int n, int res) {
        if (n <= 1) {
            return res;
        }
        return tail(n - 1, n * res);
    }
}
