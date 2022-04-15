package zuoshensuanfa.basesort;

/**
 * 选择排序 O(N2)
 *
 * 不断从比较i和i+1位置并交互，每次比较选出一个数
 * */
public class XuanZeSort {

    public static int[] selectionSort(int[] inputArr){
        int[] arr = inputArr;
        if (arr == null || arr.length < 2) return arr;

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = {5,3,4,9,12,7,8,1};
        int[] result=selectionSort(test);
        for (int item:result) {
            System.out.print(item+", ");
        }
    }
}
