package suanfa.shuzu;

/**
 * 二分查找法
 */
public class BinearySearch {

    public static void main(String[] args) {
        int[] s = {1, 3, 5, 6, 10, 12, 15, 21, 23, 33, 50};
        int find = binarySearch1(s, 33);
        System.out.println("33 所在下标：" + find + ((find != -1) ? ",存在" : ",不存在"));
        int find2 = binarySearch1(s, 13);
        System.out.println("13 所在下标：" + find2 + ((find2 != -1) ? ",存在" : ",不存在"));

        int t1 = binarySearch2(s,33);
        int t2 = binarySearch2(s,13);
        int t3 = binarySearch2(s,21);
        System.out.println(String.format("下标依次是：%d,%d,%d",t1,t2,t3));
    }


    // 二分搜索

    /**
     * @deprecated 找出target下标
     */
    private static int binarySearch1(int[] arr, int target) {
        if (arr == null || arr.length < 2) return 0;
        // 在[l...r] 范围内查找target
        int l = 0;
        int r = arr.length - 1;
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

    private static int binarySearch2(int[] input, int target) {
        if (input == null || input.length < 2) return 0;
        int l = 0;
        int r = input.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (input[mid] == target) {
                return mid;
            } else if (input[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
