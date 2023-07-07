package zuoshensuanfa.basesort.test;

public class MaopaoTest {

    public static void bubblingSort(int[] data){
        for (int i = data.length-1; i >0; i--) {
            for (int j =0; j< i;j++){
                if (data[j]>data[j+1]){
                    sweep(data,j,j+1);
                }
            }
        }
    }

    private  static void sweep(int[]data, int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test = {1,23,14,2,5,10,6,11,6,7};
        bubblingSort(test);
        for (int i : test) {
            System.out.print(i+", ");
        }
    }
}
