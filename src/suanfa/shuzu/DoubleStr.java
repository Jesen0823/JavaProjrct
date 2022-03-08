package suanfa.shuzu;
/**
 * 在一个字符串中寻找没有重复字母的最长子串
 * -如”abcabcbb”，则结果为”abc”
 * -如”bbbbb”，则结果为”b”
 * -如”pwwkew”,则结果为”wke”
 * */
public class DoubleStr {

    public static void main(String[] args) {
        String s = "abcabcbb";
       int ret = findChongfu(s);
       System.out.println("没有重复字母最长子串 的长度："+ret);
    }

    // 双指针滑块
    private static int findChongfu(String s) {
        char[] array = s.toCharArray();

        int[] freq = new int[256];
        int l = 0, r = -1;  //滑动窗口为s[l,..r]
        int res = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[array[r + 1]] == 0)
                freq[array[++r]]++;
            else
                freq[array[l++]]--;
            // 返回数组的长度
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
