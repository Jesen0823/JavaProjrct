package zuoshensuanfa.basesort;

import zuoshensuanfa.Utils;

/**
 * 冒泡排序  O(N²)
 * 从后往前，每个数都与相邻数比较
 */
public class MaoPaoSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 从后往前，每一轮确定一个数
        for (int i = arr.length - 1; i > 0; i--) {
            // 对每个数前面的数，都两两比较
            for (int j = 0; j < i; j++) {
                // 将小的放前面
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        // 异或 相同为0不同为1，即无进位相加
        // 0^N = N, N^N = 0  且满足交换律结合律
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    public static void main(String[] args) {
        int[] test = {5,3,4,9,12,7,8,1};
        bubbleSort(test);
        for (int item:test) {
            System.out.print(item+", ");
        }

        int []rand = Utils.generateRandomArray(100000,9000);
        long begin = System.currentTimeMillis();
        bubbleSort(rand);
        long end = System.currentTimeMillis();
        System.out.println(rand.length+"个元素，耗时 "+(end-begin)+" ms");
       /* for (int item:rand) {
            System.out.print(item+", ");
        }*/
    }
}
