package zuoshensuanfa.erchashu;

/**
 * 纸条折痕问题，求打印 对折 n次后的折线排列
 */
public class PaperFoldTree {

    public static void printPaper(int N) {
        printProcess(1, N, true);
    }

    /**
     * @param i    节点层数
     * @param N    总共的层数 即对折次数
     * @param down true代表凹痕，false 凸痕
     */
    private static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.print(down ? "凹 " : "凸 ");
        printProcess(i + 1, N, false);
    }

    public static void main(String[] args) {

        printPaper(3);
    }
}
