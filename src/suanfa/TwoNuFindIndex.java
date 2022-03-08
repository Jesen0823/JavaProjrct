package suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组，已知两数之和是N,求两数在数组中的下标
 */
public class TwoNuFindIndex {

    // 求那两个数的位置
    int index1;
    int index2;

    public static void main(String[] args) {

        int[] test = {1, 5, 23, 8, 10, 4, 3};
        int sum = 15;


        int[] result = findTheIndex(test, sum);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] findTheIndex(int[] source, int sum) {
        int [] ids = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            int cur = source[i];
            map.put(cur, i);
        }
        int sec = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(sum - entry.getKey())) {
                ids[0] = entry.getValue();
                sec = sum - entry.getKey();
                break;
            }
        }
        ids[1] = map.get(sec);
        return ids;
    }


}
