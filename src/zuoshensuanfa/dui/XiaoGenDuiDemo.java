package zuoshensuanfa.dui;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 小根堆题目
 *
 * 给定一个几乎有序的数组，要排成有序，每个元素移动的距离不会超过 k,且k比数组长度小很多
 * 如： [1,0,3,5,6,7,9,11,13,16,15,17,18,20] k=2
 * 请排序
 *
 * */
public class XiaoGenDuiDemo {


    public static void sortArrDistanceLessK(int[] arr, int k){
        // 优先队列默认就是小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        // 先把前k个数放入小根堆
        for (; index<=Math.min(arr.length,k);index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++,index++) {
            heap.add(arr[index]);
            // 弹出一个放入i位置
            arr[i] = heap.poll();
        }
        // 剩下的全部弹出放入数组
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }

    }

    /**
     * java 小根堆工具 PriorityQueue 默认就是一个小根堆，可以传入比较器设置成大根堆工具类
     * 扩容是先2倍，不够的话再4倍，8倍
     * 复杂度 O(logN)
     * */
    public static void priprityQueueTest(){
        // 声明一个小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 大根堆
        //PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComporator());
        heap.add(8);
        heap.add(1);
        heap.add(9);
        heap.add(2);
        heap.add(4);
        heap.add(11);

        while (!heap.isEmpty()){
            System.out.print(heap.poll()+", ");
        }
    }

    // 自定义比较器
    static class MyComporator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

    public static void main(String[] args) {
        priprityQueueTest();

        int[] test = {1,0,3,5,6,7,9,11,13,16,15,17,18,20};
        int k = 2;
        sortArrDistanceLessK(test,k);

        System.out.print("\n----------\n");
        for (int i : test) {
            System.out.print(i+", ");
        }
    }
}
