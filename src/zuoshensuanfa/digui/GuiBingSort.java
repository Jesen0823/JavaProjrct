package zuoshensuanfa.digui;

/**
 * 归并排序 O(N *logN) 空间O(N)
 * <p>
 * 先找到中间点，分成左右两部分
 * 然后分别让左右部分各有序
 * 最后让整体有序是用了外排法
 */
public class GuiBingSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }

        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left; // 左侧下标
        int p2 = mid + 1; // 右侧下标
        while (p1 <= mid && p2 <= right) {
            // 谁小把谁考到help
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 下面两个while如果有一个执行，表明p1 p2有一个已经走到底已经越界，剩下的考入help
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        // 辅助help考入原数组
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
    }


    public static void main(String[] args) {
        int[] test = new int[]{11, 3, 3, 7, 2, 13, 5, 1, 18, 12, 6, 5, 19};
        mergeSort(test);
        for (int item : test) {
            System.out.print(item + ", ");
        }
    }
}
