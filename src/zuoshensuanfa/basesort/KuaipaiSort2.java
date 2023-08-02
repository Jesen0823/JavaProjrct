package zuoshensuanfa.basesort;

import zuoshensuanfa.Utils;

public class KuaipaiSort2 {

    public static void main(String[] args) {
        int[] test = {12, 4, 13, 12, 9, 0, 21, 3, 4, 6, 1, 2, 12, 19};
        quickSort(test, 0, test.length - 1);
        for (int item : test) {
            System.out.print(item+",");
        }

        int[] test2 = Utils.generateRandomArray(100000, 10000);
        long t1 = System.currentTimeMillis();
        quickSort(test2,0,test2.length-1);
        long t2 = System.currentTimeMillis();
        // 测得200000条数据耗时31毫秒
        System.out.println(" if array length:"+test2.length+", will use time:"+(t2-t1));
    }

    private static void quickSort(int[] arr, int left, int right) {
        int pivot; // 定义中枢值
        if (left < right) {
            // 得到每次的中枢值
            pivot = getPivotNum(arr, left, right);
            // 对中枢左边排序
            quickSort(arr,left,pivot-1);
            // 对中枢右边排序
            quickSort(arr,pivot+1,right);
        }
    }

    private static int getPivotNum(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && pivot <= arr[right]) {
                // 右边界向左扩展
                right--;
            }
            // 右边界发现比中枢小的值了，放到左边界
            arr[left] = arr[right];
            while (left < right && pivot >= arr[left]) {
                // 左边界向右扩展
                left++;
            }
            // 左边界发现比中枢大的值了，放到右边界
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
