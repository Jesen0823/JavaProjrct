package suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串字母异位
 * 给定两单词，判断所含字母种类个个数是否相同，如：“ready” 和 "deary"
 *
 * */
public class TwoStringYiwei {

    public static void main(String[] args) {
        String str1 = "padding";
        String str2 = "pingadd";
        boolean result = checkTwoStr(str1,str2);
        System.out.println("result is :"+ result);
    }


    public static boolean checkTwoStr(String s1,String s2){
        Map<Character,Integer> set1 = new HashMap<>();
        Map<Character,Integer> set2 = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            if (set1.containsKey(ch)){
                int num = set1.get(ch);
                set1.put(ch,num+1);
            }else {
                set1.put(ch,1);
            }
        }

        for (char ch : s2.toCharArray()) {
            if (set2.containsKey(ch)){
                int num = set2.get(ch);
                set2.put(ch,num+1);
            }else {
                set2.put(ch,1);
            }
        }

        return set1.equals(set2);
    }
}
