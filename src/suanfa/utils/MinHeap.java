package suanfa.utils;

public class MinHeap {
    private int[] data;  //构造小顶堆的数组；

    /*
     *构造函数；
     */
    public MinHeap(int[] data) {
        this.data = data;
        buildMinHeap();
    }

    /*
     *构造小顶堆,大小为k；
     */
    private void buildMinHeap() {
        for (int i = (data.length) / 2 - 1; i >= 0; i--) {
            // 对有孩子结点的元素heapify
            heapify(i);
        }
    }

    /**
     * 从当前节点开始堆化
     */
    private void heapify(int i) {
        int left = ((i + 1) << 1) - 1;
        int right = ((i + 1) << 1);
        int min = i;
        if (left < data.length && data[left] < data[i]) min = left;
        if (right < data.length && data[right] < data[min]) min = right;
        if (min == i) return;
        swap(i, min);
        heapify(min);
    }

    /*
     *判断当前数，若其大于堆顶元素，取出堆顶，将该数放入堆顶并重新堆化；否则不改变原堆
     */
    public void setRoot(int num) {
        if (num <= data[0]) return;
        data[0] = num;
        //重新堆化；
        heapify(0);
    }

    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
