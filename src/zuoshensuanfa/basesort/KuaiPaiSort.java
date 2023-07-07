package zuoshensuanfa.basesort;

import zuoshensuanfa.Utils;

import java.util.Arrays;

/**
 * 一个数组，把小于num的数放在数组左边，大于num的放在右边
 * 时间复杂度O(N) 空间O(1)
 * <p>
 * 定义一个 <=区 起始点是第一个元素
 * 若[i] <= num 则 <=区的下一个数与[i]交换，然后<=区右扩，且i++
 * 反之，若[i]>num,则直接i++
 * <p>
 * 升级：
 * 一个数组，把小于num的数放在数组左边，大于num的放在右边，等于的放中间
 * 画图： 小于区) |_3_5_6_3_4_5_2_6_7_9_11_8_5_| (大于区
 * 定义一个小于区Q1 大于区Q2
 * 若[i] < num, 则[i]和小于区下一个数交换，小于区右扩，且i++
 * 若[i] = num,则直接i++
 * 若[i] > num, [i]和大于区前一个交换,大于区左扩,i不变
 */
public class KuaiPaiSort {

    /**
     * 快排 1.0: O(N2)
     * 数组中最后一个数作为num, 前面的数用num分割，小于的放左边大于的放右边，即  <=num | >num |num|
     * 然后把大于区的与num比较交换，小的放前面
     * 于是相当于小于区被扩充
     *
     * 递归：
     * 接着，在小于num区取最后一个数作为新num,重复划分
     * 在大于num区取最后一个数作为新num，重复划分
     * 直到递归结束
     * */

    /**
     * 快排 2.0: O(N2)
     * 数组中最后一个数作为num, 前面的数用num分割，小于的放左边，等于的放中间，大于的放右边，即  <=num | ==num |>=num |num|
     * 然后把大于区的第一个数与num比较交换，则等于区被扩充
     * 小于区最后一个数与num比较交换，继续扩大等于区
     *
     * 递归：
     * 等于区不用管了
     * 小于区最后一个与他前面比较交换
     * 大于区最后一个与大于区前面的所有数比较交换
     * 直到递归结束
     * */


    /**
     * 快排 3.0: O(N*logN)
     * 数组中随机选取一个数作为num, 用num分割数组，小于的放左边，等于的放中间，大于的放右边，即  <=num | ==num |>=num
     */

    public static int[] quickSort(int[] pa) {
        if (pa == null || pa.length < 2) {
            return pa;
        }
        int[] arr = Arrays.copyOf(pa,pa.length);
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // 随机选一个数与最后一个数交换，然后r存的就是这个随机选取的数
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            // 用R(随机选取的)划分左右边界
            int[] p = partition(arr, l, r);
            // 小于区递归
            quickSort(arr, l, p[0] - 1);
            // 大于区递归
            quickSort(arr, p[1] + 1, r);
        }
    }

    // 返回划分后的等于区的左边界和右边界，长度2的数组，即划分后等于区的头和尾
    private static int[] partition(int[] arr, int l, int r) {
        // 小于区右边界
        int less = l - 1;
        // 大于区左边界
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                // 交换，小于区右扩
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                // 交换，大于区左扩
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] test = new int[]{3, 5, 6, 3, 4, 5, 2, 6, 7, 9, 11, 8, 5};
        int []result= quickSort(test);
        for (int i : result) {
            System.out.print(i+", ");
        }

        int[] test2 = Utils.generateRandomArray(200000, 10000);
        long t1 = System.currentTimeMillis();
        int[] result2 = quickSort(test2);
        long t2 = System.currentTimeMillis();
        // 测得200000条数据耗时20毫秒
        System.out.println("use time:"+(t2-t1));
    }
}
