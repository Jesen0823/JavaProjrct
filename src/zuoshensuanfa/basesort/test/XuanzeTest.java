package zuoshensuanfa.basesort.test;

public class XuanzeTest {

    public static void selectionSort(int[] data){
        for (int i = 0; i < data.length; i++) {
            int mindex = i;
            for(int j =i+1; j<data.length;j++){
                mindex = data[j] > data[mindex]? mindex:j;
            }
            sweep(data,i,mindex);
        }
    }

    private  static void sweep(int[]data, int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test = {1,23,14,2,5,10,6,11,6,7};
        selectionSort(test);
        for (int i : test) {
            System.out.print(i+", ");
        }
    }
}
