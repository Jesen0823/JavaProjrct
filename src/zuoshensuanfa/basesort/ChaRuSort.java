package zuoshensuanfa.basesort;

/**
 * 插入排序 O(N平方) 空间O(1)
 *
 * 从0开始
 * 保证0~1有序：先到1位置，比前面小就和前面交换
 * 保证0~2有序：从2往前比较，交换，保证有序
 * 保证0~3有序：从3往前比较，交换，保证有序
 * ...
 * 就这样边走边回头
 * */
public class ChaRuSort {

    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2) return;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    // 异或运算 j和i不能是同一个对象或同一个地址
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) throws InterruptedException {
        int[] test = {5,3,4,9,12,7,8,1};
        insertSort(test);
        for (int i : test) {
            System.out.println(i+", ");
        }
    }
}
