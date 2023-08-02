package zuoshensuanfa.basesort;

/**
 * 插入排序 O(N平方) 空间O(1)
 * <p>
 * 从0开始
 * 保证0~1有序：先到1位置，比前面小就和前面交换
 * 保证0~2有序：从2往前比较，交换，保证有序
 * 保证0~3有序：从3往前比较，交换，保证有序
 * ...
 * 就这样边走边回头
 * 与打牌整理牌一个道理
 * 取未排序区间的元素，在已排序位置选择合适位置插入，保证已排序的序列一直是有序的
 */
public class ChaRuSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        // 第一个数之后，每个数走一遍
        for (int i = 1; i < arr.length; i++) {
            // 每个数的前面的数，比较交换
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void insertSort2(int[] arr) {
        for (int i = 1; i <= arr.length; i++) {
            // 寻找元素 arr[i] 合适的插入位置
            for (int j = i - 1; j > 0; j--)
                if (arr[j] > arr[j - 1])
                    swap(arr, j, j - 1);
                else
                    break;
        }
    }

    // 异或运算 j和i不能是同一个对象或同一个地址
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) throws InterruptedException {
        int[] test = {5, 3, 4, 9, 12, 7, 8, 1,0};
        insertSort(test);
        for (int i : test) {
            System.out.print(i + ", ");
        }

        System.out.println("\n");

        int[] test2 = {4, 1, 0, 23, 13, 1, -1, 5, 54, 8};
        insertSort2(test2);
        for (int i : test2) {
            System.out.print(i + ", ");
        }
    }
}
