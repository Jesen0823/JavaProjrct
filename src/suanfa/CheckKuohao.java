package suanfa;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 利用栈判断字符串中的括号是否合法
 */
public class CheckKuohao {

    public static void main(String[] args) {
        String str = "{[((x+y)]}";
        boolean result = isStrVallid(str);
        System.out.println("result: " + result);

        String str2 = "{p:[s(a:7)]}";
        boolean valid = isValid(str2);
        System.out.println("result2: " + valid);
    }


    private static boolean isStrVallid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
                //遍历过程中如果stack为空，证明左符号少于右符号
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        //遍历完成以后如果stack不为空，那么证明左符号多于右符号
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        // 取出字符串中的每一个括号
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 如果遇到左括号，进行压栈，
            // 如果遇到右括号，进行出栈
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                case '}':
                case ']':
                    // 如果此时遇到了右括号
                    if (stack.isEmpty()) {
                        return false;
                    }
                    // 如果此时栈中保存着左括号,看与右括号是否匹配
                    // 移除栈顶元素
                    char left = stack.pop();
                    // 如果不匹配
                    if (!((left == '(' && ch == ')') || (left == '{' && ch == '}') || (left == '[' && ch == ']'))) {
                        return false;
                    }
                    break;
                default:
                    break;
            }

        }
        // 此时字符串中字符已经都走过了
        // 栈中应该是空的
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
