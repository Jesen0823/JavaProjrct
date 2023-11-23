package zuoshensuanfa.basesort;

import zuoshensuanfa.Utils;

/**
 * 选择排序 O(N2) 每次选择一个最大/最小数
 * 每一个数都跟他后面的数比较，所以是N平方
 * 不断从比较i和i+1位置并交互，每次比较选出一个数
 *
 */
public class XuanZeSort {

    public static int[] selectionSort(int[] inputArr) {
        int[] arr = inputArr.clone();
        if (arr == null || arr.length < 2) return arr;

        // 每个数走一遍
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // 每个数[i]与它后面的数比较，找出最小数
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            // [i]与后面最小的数交换
            if (i != minIndex) {
                swap(arr, i, minIndex);
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = {5, 3, 4, 9, 12, 7, 8, 1};
        int[] result = selectionSort(test);
        for (int item : result) {
            System.out.print(item + ", ");
        }

        int[] test2 = Utils.generateRandomArray(200000, 10000);
        long t1 = System.currentTimeMillis();
        int[] result2 = selectionSort(test2);
        long t2 = System.currentTimeMillis();
        // 测得200000条数据耗时3.4秒
        System.out.println(test2.length+"条数据，use time:" + (t2 - t1)+"ms");
        /*for (int item : result2) {
            System.out.print(item + ", ");
        }*/
    }
}
