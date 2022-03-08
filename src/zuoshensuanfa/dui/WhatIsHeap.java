package zuoshensuanfa.dui;

/**
 * 1). 什么是堆？
 * 堆是一种特殊的平衡二叉树
 * 优先级队列的结构也是堆
 * <p>
 * <p>
 * 2). 什么是二叉树？
 * 一个数组可以对应为一个完全二叉树：
 * <p>
 * 值：  3,5,2,7,1,9,6
 * ———————————————————
 * 下标：0,1,2,3,4,5,6
 * <p>
 * 下标对应二叉树：规则是先左再右
 * 0
 * /  \
 * 1    2
 * /\   / \
 * 3  4  5  6
 * 则元素arr[i]在二叉树中的父节点下标是 (i-1)/2
 * <p>
 * <p>
 * 3). 什么是完全二叉树？
 * 每一个节点都有左右child,就是完全二叉树
 * <p>
 * <p>
 * 4). 大根堆小根堆
 * 完全大根堆的每一颗子树，它的最大值一定是根节点，如：
 * 6
 * / \
 * 5    4
 * /\   / \
 * 4  3  3  0
 * 完全小根堆的每一颗子树，它的最小值一定是根节点，如：
 * 1
 * / \
 * 3   2
 * /\   /\
 * 5  7 6 5
 * <p>
 * <p>
 * 5). 于是给定一个数组，就可以将数组转换成大根堆，
 * 每一个数向上比较与其父节点比较大小，大的往上交换，直到结束，就得到一个大根堆:
 * <p>
 * public static void heapInsert(int[] arr, int index) {
 * while (arr[index] > arr[(index - 1) / 2]) {
 * swap(arr, index, (index - 1) / 2);
 * index = (index - 1) / 2;
 * }
 * }
 * <p>
 *     
 * 6). 假设给定一些数，形成大根堆，然后要求去掉最大数后，剩下的仍然是一个大根堆
 * 方案： 先去掉大根节点，即0位置的数，然后把最后一个数放m到0位置，作为大根(暂时不管m的大小)
 * 然后 heapSize--;
 * 重新调整数的结构，每一个子树的根节点与左右child比较替换，大的作为根节点，一整套下来，剩下的就是个大根堆了。
 */
public class WhatIsHeap {

    /**
     * 堆排序 N*log(N)
     *
     * */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) { // O(N)
            heapInsert(arr, i); // O(logN)
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {  // O(N)
            heapify(arr, 0, heapSize); // O(logN)
            swap(arr, 0, --heapSize); // O(1)
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        // 左child下标
        int left = index * 2 + 1;

        while (left < heapSize) { // 若下方还有child
            // 两个child谁大，就把下标给largest, left+1 是右child
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;

            // father即arr[index]和children,谁大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] test = new int[]{3, 5, 2, 7, 1, 9, 6};
        heapSort(test);
        Thread.sleep(1000);

        for (int i : test) {
            System.out.print(i + ",");
        }
    }
}
