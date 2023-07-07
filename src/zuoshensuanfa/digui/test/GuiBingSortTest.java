package zuoshensuanfa.digui.test;

public class GuiBingSortTest {

    public static void main(String[] args) {
        int[] test = {1, 4, 12, 14, 12, 5, 8, 19, 0, 1, 34, 6, 3, 2, 3, 5, 8};
        mergeSort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + ",");
        }
    }

    private static void mergeSort(int[] test) {
        if (test == null || test.length < 2) {
            return;
        }
        process(test, 0, test.length - 1);
    }

    private static void process(int[] data, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(data, l, mid);
        process(data, mid + 1, r);
        merge(data, l, mid, r);
    }

    private static void merge(int[] data, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = data[p1] < data[p2] ? data[p1++] : data[p2++];
        }
        while (p1 <= mid) {
            help[i++] = data[p1++];
        }
        while (p2 <= r) {
            help[i++] = data[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            data[l + j] = help[j];
        }
    }
}
