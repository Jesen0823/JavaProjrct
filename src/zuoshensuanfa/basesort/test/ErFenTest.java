package zuoshensuanfa.basesort.test;

import java.util.Arrays;

public class ErFenTest {

    public static int searchTest(int[] data, int target) {
        return search(data, 0, data.length - 1, target);
    }

    private static int search(int[] data, int l, int r, int target) {
        if (l > r) return -1;
        int mid = l +  ((r - l)>>1);
        for (int i = 0; i < data.length; i++) {
            if (data[mid] < target) {
                return search(data, mid - 1, r, target);
            } else if (data[mid] == target) {
                return mid-1;
            } else return search(data, l, mid - 1, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 4, 6, 7, 7, 7, 9, 12, 14, 16, 17};
        int result = searchTest(test, 7);
        System.out.print(String.format("target is %d, index is %d", test[result], result));
    }
}
