package zuoshensuanfa.tanxin;

import java.util.PriorityQueue;

/**
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的金
 * 条，不管切成长度多大的两半，都要花费20个铜板。
 * 一群人想整分整块金条，怎么分最省铜板?
 *
 * 例如，给定数组{10,20,30}，代表一共三个人，整块金条长度为10+20+30=60。
 * 金条要分成10,20,30三部分。如果先把长度60的金条分成10和50，花费60；
 * 再把长度50的金条分成20和30，花费50；一共花费110铜板。
 * 但是如果先把长度60的金条分成30和30，花费60；再把长度30金条分成10和20，
 * 花费30；一共花费90铜板。
 * 输入一个数组，返回分割的最小代价。
 *
 * 步骤：
 * 1. 放入小根堆
 * 2. 拿出两个数(树顶最小的), 结合(求和)后丢入小根堆
 * 3. 重复步骤 2
 *
 *  哈夫曼树
 * */
public class TanXin02 {

    public static int splitGolden(int[] arr){
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size()>1){
            cur = pQ.poll() + pQ.poll();
            sum+= cur;
            pQ.add(cur);
        }
        return sum;
    }

    public static void main(String[] args) {
        int [] test = {10,20,30,40};
        int min = splitGolden(test);
        System.out.println(min);
    }
}
