package xiaomi;

public class BigIntegerMinus {
    public static void main(String[] args) {
        String a = "1231231237812739878951331231231237812739878951331231231237812739878951331230000000000000000000000001",
                b = "331231231237812739878951331231231";
//        String a = "82312",
//                b = "19513";
        System.out.println(minus(a, a.length() - 1, b, b.length() - 1, 0));
    }

    public static String minus(String a, int i, String b, int j, int carrybit) {
        if (j < 0) {
            if (carrybit == 1) {
                if (Character.getNumericValue(a.charAt(i)) >= 1) {
                    String res = minus(a, i - 1, b, j, 0) + (Character.getNumericValue(a.charAt(i)) - 1);
                    if ("0".equals(res)) {
                        return "";
                    }
                    return res;
                } else {
                    return minus(a, i - 1, b, j, 1) + 9;
                }
            }
            return a.substring(0, i + 1);
        }
        boolean flag = Character.getNumericValue(a.charAt(i)) >= Character.getNumericValue(b.charAt(j));
        if (flag && carrybit == 0) {
            return minus(a, i - 1, b, j - 1, 0) + (Character.getNumericValue(a.charAt(i)) - Character.getNumericValue(b.charAt(j)));
        } else if (flag) {
            if (Character.getNumericValue(a.charAt(i)) >= Character.getNumericValue(b.charAt(j)) + 1) {
                return minus(a, i - 1, b, j - 1, 0) + (Character.getNumericValue(a.charAt(i)) - 1 - Character.getNumericValue(b.charAt(j)));
            } else {
                return minus(a, i - 1, b, j - 1, 1) + (Character.getNumericValue(a.charAt(i)) + 9 - Character.getNumericValue(b.charAt(j)));
            }
        } else if (carrybit == 0) {
            return minus(a, i - 1, b, j - 1, 1) + (Character.getNumericValue(a.charAt(i)) + 10 - Character.getNumericValue(b.charAt(j)));
        } else {
            return minus(a, i - 1, b, j - 1, 1) + (Character.getNumericValue(a.charAt(i)) + 9 - Character.getNumericValue(b.charAt(j)));
        }
    }
}
