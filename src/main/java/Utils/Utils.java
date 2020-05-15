package Utils;

import java.util.*;

public class Utils {

    public static int max3(int a, int b, int c) {
        if (a < b) {
            a = b;
        }
        if (a < c) {
            a = c;
        }
        return a;
    }

    public static int min3(int a, int b, int c) {
        if (a > b) {
            a = b;
        }
        if (a > c) {
            a = c;
        }
        return a;
    }

    private static int c = 0;

    public static TreeNode createTreeBypre(String[] strs) {
        c = 0;
        return createBypre(strs);
    }

    private static TreeNode createBypre(String[] strs) {
        TreeNode node;
        if (strs[c].equals("#")) {
            c++;
            return null;
        }
        node = new TreeNode(Integer.valueOf(strs[c++]));
        node.left = createBypre(strs);
        node.right = createBypre(strs);
        return node;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printMatrixZigzag(int[][] matrix) {
        int i = 0, j = 0, m = 0, n = 0;
        boolean upper = true;
        while (i < matrix.length && j < matrix[0].length) {
            printByDiagonal(matrix, i, j, m, n, upper);
            upper = !upper;
            if (i < matrix.length - 1) {
                i++;
            } else {
                j++;
            }
            if (n < matrix[0].length - 1) {
                n++;
            } else {
                m++;
            }
        }
    }

    private static void printByDiagonal(int[][] matrix, int i, int j, int m, int n, boolean upper) {
        if (i == m) {
            while (j <= n) {
                System.out.print(matrix[i][j++] + " ");
            }
        } else if (j == n) {
            while (i <= m) {
                System.out.print(matrix[i++][j] + " ");
            }
        } else if (upper) {
            while (i >= m && j <= n) {
                System.out.print(matrix[i--][j++] + " ");
            }
        } else {
            while (i >= m && j <= n) {
                System.out.print(matrix[m++][n--] + " ");
            }
        }
        System.out.println();
    }

    public static void printTree(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        TreeNode last = node;
        TreeNode iLast = last;
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top.left != null) {
                iLast = top.left;
                queue.offer(iLast);
            }
            if (top.right != null) {
                iLast = top.right;
                queue.offer(iLast);
            }
            System.out.print(top.val + " ");
            if (top == last) {
                last = iLast;
                System.out.println();
            }
        }
    }

    public static void printTwoDimensionalArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%d ", a[i][j]);
            }
            System.out.println();
        }
    }

    public static List<String> generateStringsSpecifyCharacters(List<Character> characters, int len, int size) {
        int min = 0;
        int max = characters.size() - 1;
        int range = max - min + 1;
        List<String> res = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder(len);
            for (int j = 0; j < len; j++) {
                int rand = (int) (Math.random() * range) + min;
                sb.append(characters.get(rand));
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        List<Character> characters = Arrays.asList('(',')');
        List<String> strings = generateStringsSpecifyCharacters(characters,6,10);
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
