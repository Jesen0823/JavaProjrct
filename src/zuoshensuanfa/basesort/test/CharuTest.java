package zuoshensuanfa.basesort.test;

public class CharuTest {

    public static void main(String[] args) {
        int[] test={4,1,0,23,13,1,5,54,8};
        sort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]+",");
        }

    }

    public static void sort(int[] arr){
        for (int i = 1; i <= arr.length; i++) {
            // 寻找元素 arr[i] 合适的插入位置
            for( int j = i-1 ; j > 0 ; j -- )
                if( arr[j]>arr[j-1])
                    swap( arr, j , j-1 );
                else
                    break;
        }
    }

    private static void swap(int[] input, int m, int n) {
        int tmp = input[m];
        input[m] = input[n];
        input[n] = tmp;
    }
}
