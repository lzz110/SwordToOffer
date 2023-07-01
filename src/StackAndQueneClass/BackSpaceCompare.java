package StackAndQueneClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/6/22 20:43
 */
public class BackSpaceCompare {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder ssb = new StringBuilder(); // 模拟栈
        StringBuilder tsb = new StringBuilder(); // 模拟栈
        // 分别处理两个 String
        for (char c : s.toCharArray()) {
            if (c != '#') {
                ssb.append(c); // 模拟入栈
            } else if (ssb.length() > 0){ // 栈非空才能弹栈
                ssb.deleteCharAt(ssb.length() - 1); // 模拟弹栈
            }
        }
        for (Character c : t.toCharArray()) {
            if (c != '#') {
                tsb.append(c); // 模拟入栈
            } else if (tsb.length() > 0){ // 栈非空才能弹栈
                tsb.deleteCharAt(tsb.length() - 1); // 模拟弹栈
            }
        }
        return ssb.toString().equals(tsb.toString());
    }

}
