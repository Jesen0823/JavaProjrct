package zuoshensuanfa.digui;

import zuoshensuanfa.Utils;

/**
 * 逆序对问题
 * <p>
 * 一个数组中 左边数若大于右边数，则这两个数构成一个逆序对
 * 如： [3,2,4,5,0]
 * 逆序对： 3,2  5,0  3,0  2,0  4,0
 */
public class GuiBingNiXuDui {

    public static void main(String[] args) {
        int[] test = {3,2,4,5,0};
        int result = countReversePairs(test);
        System.out.print("逆序对个数："+result);

        int[] test2 = Utils.generateRandomArray(200000, 10000);
        long t1 = System.currentTimeMillis();
        int result2 = countReversePairs(test2);
        long t2 = System.currentTimeMillis();
        // 测得200000条数据耗时20毫秒
        System.out.println("逆序对："+result2+",use time:"+(t2-t1));
    }

    public static int countReversePairs(int[] data) {
        if (data == null || data.length < 2) {
            return 0;
        }
        int[] helper = new int[data.length];
        return mergeSort(data, 0, data.length - 1, helper);
    }

    private static int mergeSort(int[] data, int l, int r, int[] helper) {
        if (l >= r) return 0;
        int mid = l + r >> 1;
        int leftCount = mergeSort(data, l, mid, helper);
        int rightCount = mergeSort(data, mid + 1, r, helper);
        int mergeCount = merge(data, l, mid, r,helper);
        return leftCount + rightCount + mergeCount;
    }

    private static int merge(int[] data, int l, int mid, int r, int[] helper) {
        int k =l;
        int m = 0;
        int p1 = l;
        int p2 = mid+1;
        while (p1<=mid && p2<=r){
            if (data[p1] <= data[p2]){
                helper[k++] = data[p1++];
            }else {
                helper[k++] = data[p2++];
                m+=(mid-p1+1); // data[i]~data[mid]均与data[p2]构成了逆序对，共mid-i+1对
            }
        }
        while (p1<=mid){
            helper[k++] = data[p1++];
        }
        while (p2<=r){
            helper[k++] = data[p2++];
        }
        p1 = l;
        k = l;
        while (p1<=r){
            data[p1++] = helper[k++];
        }
        return m;
    }
}
