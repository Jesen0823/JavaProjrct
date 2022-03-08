package suanfa.shuzu;
/**
 * 给定一个整型数组和一个数字s，找到数组中最短的一个连
 * 续子数组，使得连续子数组的数字和sum>=s，返回这个
 * 最短的连续子数组的长度值
 * 如,给定数组[2,3,1,2,4,3],s=7
 * 结果是[4,3] 返回 2
 * */
public class ChildList {
    public static void main(String[] args) {
        int[] test={2,3,1,2,4,3};

       int ret =  findChildList(test, 7);
       System.out.println(ret);
    }

    private static int findChildList(int[] arr, int target) {
        int l = 0, r = -1;  // arr[l...r]设为滑动窗口，双指针
        int sum = 0;
        int res = arr.length + 1;
        while (l < arr.length){
            if (r+1 < arr.length && sum < target){
                r++;
                sum += arr[r];
            }else {
                sum -= arr[l++];
            }

            if (sum >= target){
                // r-l+1 代表子数组的元素个数
                res = Math.min(res, r-l+1);
            }
        }

        if (res == arr.length + 1){
            return 0;
        }
        return res;
    }
}
