package suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一串数组，其中有三个数加起来等于0，请列出这样的三个数组合，不能重复
 * List + 双指针
 * */
public class ThreeNuFindIndex {

    public static void main(String[] args) {

        int [] test ={-1,2,0,-2,1,4};
        List<List<Integer>> result = threeSum(test);
        for (List<Integer> list : result) {
            System.out.print(list);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums); // 1.排序
        System.out.println("sort: ");
        for (int i = 0; i < nums.length - 2; i ++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 2.第一个元素去重
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    System.out.println("i: " + nums[i] + " left: " + nums[left] + " right: " + nums[right]);
                    while (left < right && nums[left] == nums[left + 1]) { // 3.第二个元素去重
                        left ++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) { // 4.第三个元素去重
                        right --;
                    }
                    left ++;
                } else if (sum < 0) {
                    left ++;
                } else {
                    right --;
                }
            }
        }
        return lists;
    }
}
