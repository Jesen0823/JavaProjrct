package suanfa.shuzu;

/**
 * 给定一个有序整型数组和一个整数target，在其中寻找两个
 * 元素，使其和为target。返回这两个数的索引。
 * - 如numbers =[2, 7,11, 15], target =9
 * -返回数字2,7的索引1,2（索引从1开始计算）
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] test = {1, 2, 8, 7, 12, 13, 15};

        int[] ret = findNum(test, 20);
        if (ret != null) {
            for (int i : ret) {
                System.out.println(i);
            }
        }
    }

    // 二分查找法
    private static int[] findNum(int[] arr, int target) {
        if (arr.length < 2) return null;
        int[] result = {0, 0};
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr[l] + arr[r] == target) {
                result[0] = l;
                result[1] = r;
                return result;
            } else if (arr[l] + arr[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return null;
    }


}
