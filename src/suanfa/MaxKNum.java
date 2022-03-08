package suanfa;

import suanfa.utils.MinHeap;

/**
 * 一队数中 第k大的元素
 */
public class MaxKNum {

    public static void main(String[] args) {

        int[] test = {12,6,9,14,3,1,7};

        int max1 = findKthLargest(test, 2);
        System.out.println("冒泡排序法 ：max1 = "+ max1);

        int max2 = findKthLargestWithHeap(test,2);
        System.out.println("堆排序法 ：max2 = "+ max2);

    }


    /**
     * 冒泡排序
     * 在输入数据较大的情况下会超时，适合k较小，数组较有序的排序
     * */
    public static int findKthLargest(int[] nums, int k) {

        int s = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            if (s++ >= k) break;
        }
        return nums[nums.length - k];
    }

    /**
     * 优先队列二叉堆，堆顶永远是最小的元素
     * 让堆的大小等于k
     * 先从数组中去k个元素构造k大小的小顶堆，遍历余下的数组值，依次与对顶元素比较，若大于堆顶元素，则删除堆顶元素，将新元素放入，重新建立新的小顶堆。
     * 遍历完数组，则最后的堆顶元素即是我们要找的第k个最大元素了。
     *
     * 大、小顶堆是完全二叉树，可用数组实现
     * */
    public static int findKthLargestWithHeap(int[] nums, int k) {
        // 先取K个元素放入数组topk中
        int[] topk = new int[k];
        for(int i=0; i<k; i++){
            topk[i] = nums[i];
        }

        MinHeap heap = new MinHeap(topk);

        for(int i=k; i<nums.length; i++){
            heap.setRoot(nums[i]);
        }
        return topk[0];
    }
}
