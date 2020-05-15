package Utils;

/**
 * @Description
 * @Date 2020/1/3 10:16
 **/
public class HttpUtils {


    public static void main(String[] args) {
        System.out.println();
        System.out.println();
    }

    /**
     * convert Ip addr to long number
     *
     * @param ipString
     * @return
     */
    public static long ip2Long(String ipString) {
        // 取 ip 的各段
        String[] ipSlices = ipString.split("\\.");
        long rs = 0;
        for (int i = 3; i >= 0; i--) {
            String ipPart = ipSlices[3 - i];
            // 将 ip 的每一段解析为 int，并根据位置左移 8 位
            long part = Long.parseLong(ipPart);
            long intSlice = part << 8 * i;
            // 求与
            rs = rs | intSlice;
        }
        return rs;
    }

    /**
     * convert long ip to String
     *
     * @param number
     * @return
     */
    public static String long2Ip(long number) {
        String[] ipStr = new String[4];
        for (int i = 0; i < 4; i++) {
            int pos = i * 8;
            long ipPart = number & (255 << pos);
            ipStr[3 - i] = String.valueOf(ipPart >> pos);
        }
        return String.join(".", ipStr);
    }
}
