package suanfa;

import suanfa.utils.MyDeque;

/**
 * 滑动最大窗口
 *  描述：
 *  给定整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧，滑动窗口每次只向右移动一位。求滑动窗口中的最大值
 *
 * 解法1：定义一个队列，队首元素是队列中的最大值，队列先进先出
 * */
public class SlideWindowDeque {


    public static void main(String[] args) {
        int [] test = {5,12,1,8,4,11,3,16,7};
        int []result = maxSlidingWindow(test,3);
        for (int i : result) {
            System.out.print(i+" | ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];
        int num = 0;
        //自定义队列
        MyDeque myQueue = new MyDeque();
        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            myQueue.poll(nums[i - k]);
            //滑动窗口加入最后面的元素
            myQueue.add(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;
    }
}
