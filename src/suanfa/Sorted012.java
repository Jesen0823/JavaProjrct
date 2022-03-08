package suanfa;

public class Sorted012 {

    public static void main(String[] args) {

        int num = 15;
        int []test = {12,5,5,6,32,10,5,3,11};
         sortColors(test,num);

    }

    public static void sortColors(int[] nums,int num){
        int list[] = nums;
        int len = list.length;

        int first;
        int tmp =0;
        for (int i = 0; i < len; i++) {
            tmp = num - list[i];
            first = list[i];
            for (int j = 1; j < len-i+1 ; j++) {
                if (nums[j] == tmp){
                    System.out.println(" first is:"+first);
                    System.out.println(" second is:"+nums[j]);
                    break;
                }
            }
        }
    }
}





