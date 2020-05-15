package dp.Stone_Game_877;

/**
 * @Description
 * @Date 2020/4/6 12:10
 **/
public class Stone_Game_dp_877 {
    public static void main(String[] args) {
//        int[] arr = {5, 3, 4, 5};
//        int[] arr = {7, 100, 2, 6};
        int[] arr = {1, 100, 1};
        System.out.println(stoneGame(arr));
//        System.out.println(alexPickFirst(arr, 0, arr.length - 1));
    }

    public static boolean stoneGame(int[] arr) {
        int[][] pickFirst = new int[arr.length][arr.length];
        int[][] pickLast = new int[arr.length][arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            for (int j = i; j < arr.length; j++) {
                if (i > j) {
                    continue;
                } else if (i == j) {
                    pickFirst[i][j] = arr[i];
                    pickLast[i][j] = 0;
                } else if (i + 1 == j) {
                    pickFirst[i][j] = Math.max(arr[i], arr[j]);
                    pickLast[i][j] = Math.min(arr[i], arr[j]);
                }
            }
        }
        for (int i = arr.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < arr.length; j++) {
                pickFirst[i][j] = Math.max(arr[i] + pickLast[i + 1][j], arr[j] + pickLast[i][j - 1]);
                pickLast[i][j] = Math.min(pickFirst[i + 1][j], pickFirst[i][j - 1]);
            }
        }
        int alexGain = pickFirst[0][arr.length - 1];
        return alexGain * 2 > sum;
    }

    public static int alexPickFirst(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        if (start + 1 == end) {
            return Math.max(arr[start], arr[end]);
        }
        int pickF = arr[start] + alexPickLast(arr, start + 1, end);
        int pickL = arr[end] + alexPickLast(arr, start, end - 1);
        return Math.max(pickF, pickL);
    }

    public static int alexPickLast(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        if (start + 1 == end) {
            return Math.min(arr[start], arr[end]);
        }
        int pickF = alexPickFirst(arr, start + 1, end);
        int pickL = alexPickFirst(arr, start, end - 1);
        return Math.min(pickF, pickL);
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
            int opponentGetRight = alexPick(arr, start, end - 1, true);
            return Math.min(opponentGetLeft, opponentGetRight);
        }
    }


}
