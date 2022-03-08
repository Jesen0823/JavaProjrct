package zuoshensuanfa.basesort;

/**
 * 二分查找法应用场景：
 * 1）数组中寻找某个数是否存在
 * 2）在一个有序数组中，寻找>=N 左侧的位置
 * 3）局部最小值问题
 *
 * 前提是有序数组
 * 假如数组是从小到大排序的，先找出中间位置的数M,如果M>num,则右边不可能存在num
 * 所以从左边找，继续分两半，找出中间位置。再来一次。
 *
 * O(log2N)
 * */
public class ErFenChaZhao {

}
