package StackAndQueneClass;

import java.util.*;

/**
 * 检查符号是否成对出现给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断该字符串是否有效。
 * 有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。比如 "()"、"()[]{}"、"{[]}" 都是有效字符串，而 "(]"、"([)]" 则不是。
 *
 * 思路：
 * 方法一：将括号依次入栈
 *      把下面三种情况考虑到了就行了
 *      第一种情况，字符串里左方向的括号多余了 ，所以不匹配。 括号匹配1
 *      第二种情况，括号没有多余，但是 括号的类型没有匹配上。 括号匹配2
 *      第三种情况，字符串里右方向的括号多余了，所以不匹配。 括号匹配3
 *
 * 方法二：
 *      首先我们将括号间的对应规则存放在 Map 中，这一点应该毋容置疑；
 *      创建一个栈。遍历字符串，如果字符是左括号就直接加入stack中，否则将stack 的栈顶元素与这个括号做比较，如果不相等就直接返回 false。遍历结束，如果stack为空，返回 true。
 **
 *
 */
public class ValidSymbol {

//    public boolean isValid(String s){
//        // 括号之间的对应规则
//        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
//        mappings.put(')', '(');
//        mappings.put('}', '{');
//        mappings.put(']', '[');
//        Stack<Character> stack = new Stack<Character>();
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (mappings.containsKey(chars[i])) {
//                char topElement = stack.empty() ? '#' : stack.pop();
//                if (topElement != mappings.get(chars[i])) {
//                    return false;
//                }
//            } else {
//                stack.push(chars[i]);
//            }
//        }
//        return stack.isEmpty();
//    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        if(len%2!=0) return false;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('){
                stack.push(')');
            }else if(s.charAt(i)=='{'){
                stack.push('}');
            }else if(s.charAt(i)=='['){
                stack.push(']');
            }else if(stack.isEmpty()||stack.peek()!=s.charAt(i)){
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                stack.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return stack.isEmpty();
    }
}
