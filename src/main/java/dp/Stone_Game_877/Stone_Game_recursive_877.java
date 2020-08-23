package dp.Stone_Game_877;

/**
 * @Description
 * @Date 2020/4/6 12:10
 **/
public class Stone_Game_recursive_877 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 5};
//        int[] arr = {7, 100, 2, 6};
//        System.out.println(stoneGame(arr));
        System.out.println(alexPick(arr,0,arr.length - 1,true));
    }

    public static boolean stoneGame(int[] arr) {

        return false;
    }

    public static int alexPick(int[] arr, int start, int end, boolean alexTurn) {
        if (start == end) {
            if (alexTurn) {
                return arr[start];
            } else {
                return 0;
            }
        }
        if (start + 1 == end) {
            if (alexTurn) {
                return Math.max(arr[start], arr[end]);
            } else {
                Math.min(arr[start], arr[end]);
            }
        }
        if (alexTurn) {
            int pickF = arr[start] + alexPick(arr, start + 1, end, false);
            int pickL = arr[end] + alexPick(arr, start, end - 1, false);
            return Math.max(pickF, pickL);
        } else {
            int opponentGetLeft = alexPick(arr, start + 1, end, true);
            int opponentGetRight = alexPick(arr,start,end-1,true);
            return Math.min(opponentGetLeft,opponentGetRight);
        }
    }


}
