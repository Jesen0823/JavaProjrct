package zuoshensuanfa.basesort.othertitle;

import zuoshensuanfa.Utils;

/**
 * 给定数组中：
 * 1）只有一种数是出现了奇数次，其他数都是偶数次 如: [2,13,2,4,4]
 * 2）只有2种数是出现了奇数次，其他数都是偶数次 如: [2,13,2,13,4,4,5,13,11,5]
 * 找出那些奇数次的数，比如13,11
 */
public class JishuCiDemo {

    // 第一种情况：
    public static int findOneJishuNum(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println("出现了奇数次的是：" + eor);
        return eor;
    }

    // 第二种情况：
    public static int[] findTwoJishuNum(int[] arr) {
        int eor = 0;
        for (int i=0;i < arr.length ; i++) {
            eor ^= arr[i];
        }
        // 最后 eor = a ^ b,且eor!=0 eor某一位上必然是1
        // 提取最右边的1
        int rightOne = eor & (~eor + 1);

        int eor2 = 0;
        for (int cur:arr) {
            if ((cur & rightOne) == 0){
                eor2 ^= cur;
            }
        }
        System.out.println("出现了奇数次的是：" + eor2+","+ (eor ^ eor2));
        return new int[]{eor2, (eor ^ eor2)};
    }

    public static void main(String[] args) {
        int[] test = {2, 13, 2, 4, 4};
        System.out.println("查找结果： " + findOneJishuNum(test));

        int[] test2 = {2,13,2,13,4,4,5,13,11,5};
        findTwoJishuNum(test2);

        int[] test3 = Utils.generateRandomArray(200000, 10000);
        long t1 = System.currentTimeMillis();
        findTwoJishuNum(test3);
        long t2 = System.currentTimeMillis();
        // 测得200000条数据耗时5毫秒
        System.out.println("data length:"+test3.length+", use time:" + (t2 - t1));
    }
}
