package zuoshensuanfa.basesort.test;

public class KuaiP {


    public static void main(String[] args) {
        int [] test = {1,12,4,0,10,4,2,23,2,9,12,4,9,3};
        quickSort(test,0,test.length-1);
        for (int item : test) {
            System.out.print(item+", ");
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        int pivot;
        if(left < right){
            pivot = getProvitNum(arr, left, right);
            quickSort(arr,left, pivot-1);
            quickSort(arr,pivot+1,right);
        }
    }

    private static int getProvitNum(int[]arr, int l, int r){
        int pivot = arr[l];
        while (l < r){
            while(l < r && pivot <= arr[r]){
                r--;
            }
            arr[l] = arr[r];
            while(l < r && pivot >= arr[l]){
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        return l;
    }
}
