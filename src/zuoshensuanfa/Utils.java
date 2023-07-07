package zuoshensuanfa;

public class Utils {

    /**
     * 产生随机样本数组
     * */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        double most = Math.random();
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        System.out.print("\n===================== start =====================\n");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            //System.out.print(arr[i]+", ");
        }
        System.out.print("\n===================== end =====================\n");
        return arr;
    }
}
