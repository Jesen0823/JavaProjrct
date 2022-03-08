package zuoshensuanfa.basesort;

/**
 * 冒泡排序  N平方
 * 从后往前，每个数都与相邻数比较
 */
public class MaoPaoSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

        // 打印
        for (int item : arr) {
            System.out.print(item);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        // 异或 相同为0不同为1，即无进位相加
        // 0^N = N, N^N = 0  且满足交换律结合律
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // 产生随机样本
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] aar = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < aar.length; i++) {
            aar[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return aar;
    }


    public static void main(String[] args) {
        int[] test = generateRandomArray(100, 100);
        bubbleSort(test);
    }
}
