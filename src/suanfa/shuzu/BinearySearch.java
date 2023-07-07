package suanfa.shuzu;

/**
 * 二分查找法
 */
public class BinearySearch {

    public static void main(String[] args) {
        int[] s2 = {1, 23, 5, 10, 6, 33, 50, 3, 15, 21};
        int[] s = {1, 3, 5, 6, 10, 12, 15, 21, 23, 33, 50};
        int find = binarySearch(s, 8, 10);
        System.out.println(s[find] + ", 33 所在下标：" + find);
        int find2 = binarySearch(s, 8, 6);
        System.out.println(s[find2] + ", 6 所在下标：" + find2);
    }


    // 二分搜索
    private static int binarySearch(int[] arr, int n, int target) {
        // 在[l...r] 范围内查找target
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] == target) {
                return mid;
            }

            if (target > arr[mid]) { // target 在 [mid+1 ...r]范围
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
