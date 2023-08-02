package zuoshensuanfa.basesort;

/**
 * 二分查找法应用场景：(前提给的数据是有序的)
 * 1）数组中寻找某个数是否存在
 * 2）在一个有序数组中，寻找>=N 左侧的位置
 * 3）局部最小值问题
 * <p>
 * 前提是有序数组
 * 假如数组是从小到大排序的，先找出中间位置的数M,如果M>num,则右边不可能存在num
 * 所以从左边找，继续分两半，找出中间位置。再来一次。
 * <p>
 * O(log2N)
 */
public class ErFenChaZhao {

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 11, 13, 14};
        int result = binarySearch(test, 6);
        System.out.println("二分法查找结果：" + "test[" + result + "]=" + test[result]);
        int result2 = binaryNormal(test, 6);
        System.out.println("非递归二分法查找结果：" + "test[" + result2 + "]=" + test[result2]);
    }

    /**
     * 方法1. 递归查找
     */
    public static int binarySearch(int[] pts, int dts) {
        return binaryS(pts, 0, pts.length - 1, dts);
    }

    public static int binaryS(int[] data, int l, int r, int target) {
        if (l > r) return -1;
        int mid = l + ((r - l) >> 1);
        if (data[mid] < target) {
            return binaryS(data, mid + 1, r, target);
        } else if (data[mid] == target) {
            return mid;
        } else {
            return binaryS(data, l, mid - 1, target);
        }
    }

    /**
     * 方法2：非递归查找
     */
    public static int binaryNormal(int[] pts, int target) {
        int l = 0;
        int r = pts.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (pts[mid] < target) {
                l = mid + 1;
            } else if (pts[mid] == target) {
                return mid;
            } else r = mid - 1;
        }
        return -1;
    }
}


