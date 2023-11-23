package my.test;

public class BubbleSort {
    public static void main(String[] args) {
        int[] input = {4, 1, 11, 90, 5, 2, 7, 11, 0, 3};
        proceed(input);
    }

    public static void proceed(int[] source) {
        int tmp;
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length - i - 1; j++) {
                if (source[j] > source[j + 1]) {
                    tmp = source[j + 1];
                    source[j + 1] = source[j];
                    source[j] = tmp;
                }
            }
        }
        for (int e : source) {
            System.out.print(e + ", ");
        }
    }
}
