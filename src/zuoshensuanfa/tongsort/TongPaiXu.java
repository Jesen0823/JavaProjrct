package zuoshensuanfa.tongsort;

/**
 * 桶排序
 * 桶是指一个容器，可以是栈，数组，队列等等
 * 桶排序的思想是不基于冒泡选择等比较数字大小的比较排序
 * 时间复杂度O(N)，空间O(M)
 * 需要样本的数据状况满足桶的划分
 * <p>
 * 如基数排序，要用桶排序排 [17, 13, 25, 100, 72]
 * 1).先都看做3位数： [017, 013, 025, 100, 072]
 * <p>
 * 2).按数组中，出现过的数字定义若干个桶 {0, 1, 2, 3, 5, 7},这里的桶定为队列
 * <p>
 * 3).将3位的数组，从个位开始依次放入对应的桶：
 * {0, 1, 2, 3, 5, 7}
 * ——————————————————————————
 * 100,空,072,013,025,017
 * <p>
 * 4). 所有桶里的数出队：
 * [100,072,013,025,017]
 * 5). 然后将十位数字再依次入桶：
 * {0, 1, 2, 3, 5, 7}
 * ——————————————————————
 * 100,013,025,空,空,072
 *     017
 * 6). 所有桶里的数出队：
 * [100,013,017,025,072]
 * 7). 然后将百位数字再依次入桶：
 * {0, 1, 2, 3, 5, 7}
 * ——————————————————————
 * 013,100,
 * 017
 * 025
 * 072
 * <p>
 * 最后所有出队，得到：
 * [013,017,025,072,100]
 *
 */
public class TongPaiXu {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    /**
     * 假设 [013,021,011,052,062] 其中元素个位设为 num
     * <p>
     * 桶：{0,1,2,3,5,6} 其中元素设为 e
     * ——————————————
     *    0,2,2,1,0,0,  0,0... (个位数词频)
     * 词频前缀累加：
     *   0,2,4,5,5,5,  5... 表示了新的含义，即个位上 <=桶[i] 的数有多少个，即累加词频,其中元素设为 a
     * <p>
     * 接着从右往左遍历(出桶) 放入help数组，假设当前数个位是 num,<=num的词频是a,则放入辅助空间位置是 help[a-1] ,即
     * 062 放入 4-1=3 位置
     * 052 放入 4-1-1=2 位置
     * 011 放入 2-1=1位置
     * 021 放入 2-1-1=0位置
     * 013 放入 5-1=4
     * 放完后 help = [021,011,052,062,013]
     *
     * @param digit 最长的数是几位数
     */
    private static void radixSort(int[] arr, int l, int r, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        // 有多少个数准备多少辅助空间
        int[] bucket = new int[r - l + 1];
        // 有多少位数字就循环几次，出桶进桶几次
        for (int k = 1; k <= digit; k++) {
            // count[0] 当前位k上数字是0的有多少个
            // count[1] 当前位k上数字是0和1的有多少个
            // count[2] 当前位k上数字是0,1和2的有多少个
            // count[i] 当前位k上数字是0~i的有多少个
            int[] count = new int[radix]; // 10个空间
            for (i = l; i <= r; i++) {
                j = getDigit(arr[i], k); // 得到对应k位的数字
                // 对应数字的词频加一
                count[j]++;
            }

            // 词频前缀和
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            // 数组从右往左遍历,放入辅助数组bucket
            for (i = r; i >= l; i--) {
                j = getDigit(arr[i], k);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }

            // bucket放入arr,继续下一次循环
            for (i = l, j = 0; i <= r; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    // 数字i的第k位数字是几
    private static int getDigit(int i, int k) {
        return ((i / ((int) Math.pow(10, k - 1))) % 10);
    }

    // 分析最大值是几位数
    private static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {13,21,11,52,62,120,111,6,27,98,86};
        radixSort(test);
        for (int i : test) {
            System.out.print(i+", ");
        }
    }
}
