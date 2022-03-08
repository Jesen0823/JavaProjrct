package zuoshensuanfa.digui;

/**
 * 求一个数组中最大值
 * */
public class DiguiMaxNum {

    public static int getMax(int[] arr){
        return process(arr, 0, arr.length-1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l)>>1);
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid+1,r);
        return Math.max(leftMax,rightMax);
    }

    public static void main(String[] args) {
        int[] test = new int[]{12,3,6,24,11,0,17,33,18,4,9};
        int max = getMax(test);
        System.out.print("最大值： "+max);
    }
}
