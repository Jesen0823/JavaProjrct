package zuoshensuanfa.digui;

/**
 * 归并排序 小和问题
 * 一个数组中，每一个数左边比他小的数加起来为n, 所有n加起来，称为该数组的小和
 * [1,3,4,2,5] 小和 ：1+1+3+1+1+3+4+2 = 16
 * <p>
 * 1. 直接做法，每遍历一个数，与前面数比较 复杂度 O(N2)
 * 2. 归并排序法 O(N*logN):
 * for(...i...){
 * arr[i] 右边有几个数比我大？ n个
 * 则我产生n次小和 总和：arr[i]*4
 * }
 */


public class GuiBingXiaoHe {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    // 排序的同时会求出小和
    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }

        int mid = l + ((r - l) >> 1);
        // 左侧产生小和+右侧产生小和+整体数组合并产生小和数
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        int res = 0;

        while (p1 <= mid && p2 <= right) {
            res += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 3, 4, 2, 5};
        int result = smallSum(test);
        System.out.print("小和：" + result);
    }
}
