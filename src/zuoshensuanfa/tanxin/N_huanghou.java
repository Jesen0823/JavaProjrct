package zuoshensuanfa.tanxin;

/**
 * N皇后问题是指在N*N的棋盘上要摆N个皇后，要求任何两个皇后不同行、不同列，
 * 也不在同一条斜线上。
 * 给定一个整数n，返回n皇后的摆法有多少种。
 * n=1，返回1。
 * n=2或3，2皇后和3皇后问题无论怎么摆都不行，返回0。
 * n=8,返回92。
 */
public class N_huanghou {

    /**
     * 第一种方案：O(!N)
     * */
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        // record[i] i行的放在了第几列
        int[] record = new int[n];
        return process1(0, record, n);
    }

    private static int process1(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        // 遍历i行上所有的列
        for (int j = 0; j < n; j++) {
            // 当前第i行的如果放在j列，会不会和0~(i-1) 行的发生“共线,共行,共斜线”
            // 是就无效
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j==record[k]|| Math.abs(record[k] -j )== Math.abs(i-k)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int ret = num1(8);
        System.out.println("8格子皇后：最大摆放方案数量："+ret);
    }
}
