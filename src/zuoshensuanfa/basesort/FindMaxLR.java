package zuoshensuanfa.basesort;

/**
 * 位置L-R上查找最大值
 */
public class FindMaxLR {

    public static void main(String[] args) {
        int[] data = {23, 60, 32, 1, 3, 41, 35, 36, 23, 34, 33, 22, 10, 80, 43, 22, 77};
        int find = process(data, 3, 10);
        System.out.println("查找结果：" + find);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) return arr[L];
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
