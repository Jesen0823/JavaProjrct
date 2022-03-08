package suanfa.shuzu;
/**
 * 给定一个有n个元素的数组，数组中元素的取值只有0,1,2三
 * 种可能。为这个数组排序。
 * */
public class Sort123 {

    public static void main(String[] args) {
        int test[] ={1,1,2,0,0,1,1,2,0};
        //sortCount(test);
        sortThree(test);
    }

    // 计数排序
    private static void sortCount(int[] arr){
        int[] count = {0,0,0};
        for (int i = 0; i < arr.length; i++) {
            assert arr[i] >=0 && arr[i] <=2;
            count[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            arr[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++) {
            arr[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++) {
            arr[index++] = 2;
        }

        for (int item:arr) {
            System.out.println(item);
        }
    }

    // 三路快排
    private static void sortThree(int[] arr){
        int zero = -1;        // arr[0...zero]  -->0
        int two = arr.length; // arr[two...n-1] -->2
        for (int i = 0; i < two; ) {
            if (arr[i] == 1){
                // 如果是1不做任何操作
                i++;
            }else if (arr[i] == 2){
                int tmp = arr[i];
                arr[i] = arr[--two];
                arr[two] = tmp;
            }else {
                assert arr[i] ==0;
                zero ++;

                int tmp =arr[zero];
                arr[zero] = arr[i];
                arr[i] = tmp;

                i++;
            }
        }

        // result
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
