package xiaomi;

import cn.signit.wesign.lib.common.type.BeanToMap;
import cn.signit.wesign.lib.common.type.NamingStyle;

import java.util.Map;

public class GreedyCell {
    String a;
//    int helper(int[][] map, int x, int y, int[][] memo,int[] dp) {
//
//    }

    public static void main(String[] args) {
        GreedyCell greedyCell = new GreedyCell();
        greedyCell.a="test";
        Map<String, Object> map = BeanToMap.getMap(greedyCell);
        System.out.println(map);
    }
}
