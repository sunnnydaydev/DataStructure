package stack;

/**
 * Create by SunnyDay on 2019/02/05
 * <p>
 * Leetcode  test 21
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 * <p>
 * 大概意思：给你一个子字符串，只包含'(', ')', '{', '}', '[' and ']',  这些字符，
 * 括号必须挨着匹配(如上栗子1，2，3) 嵌套时也必须匹配（栗子4，5） 。
 * <p>
 * 解决括号匹配问题
 * <p>
 * Leetcode  test 21
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 * <p>
 * 大概意思：给你一个子字符串，只包含'(', ')', '{', '}', '[' and ']',  这些字符，
 * 括号必须挨着匹配(如上栗子1，2，3) 嵌套时也必须匹配（栗子4，5） 。
 * <p>
 * 解决括号匹配问题
 * <p>
 * Leetcode  test 21
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 * <p>
 * 大概意思：给你一个子字符串，只包含'(', ')', '{', '}', '[' and ']',  这些字符，
 * 括号必须挨着匹配(如上栗子1，2，3) 嵌套时也必须匹配（栗子4，5） 。
 * <p>
 * 解决括号匹配问题
 * <p>
 * Leetcode  test 21
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 * <p>
 * 大概意思：给你一个子字符串，只包含'(', ')', '{', '}', '[' and ']',  这些字符，
 * 括号必须挨着匹配(如上栗子1，2，3) 嵌套时也必须匹配（栗子4，5） 。
 * <p>
 * 解决括号匹配问题
 * <p>
 * Leetcode  test 21
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 * <p>
 * 大概意思：给你一个子字符串，只包含'(', ')', '{', '}', '[' and ']',  这些字符，
 * 括号必须挨着匹配(如上栗子1，2，3) 嵌套时也必须匹配（栗子4，5） 。
 * <p>
 * 解决括号匹配问题
 */
/**
 * Leetcode  test 21
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 *
 * 大概意思：给你一个子字符串，只包含'(', ')', '{', '}', '[' and ']',  这些字符，
 * 括号必须挨着匹配(如上栗子1，2，3) 嵌套时也必须匹配（栗子4，5） 。
 * */

/**
 * 解决括号匹配问题
 * */

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        // 此处使用java util 包下的Stack 类实现算法，方便我们提交
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 为左边的自符时都入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topC = stack.pop();
                if (c == ')' && topC != '(') {
                    return false;
                }
                if (c == ']' && topC != '[') {
                    return false;
                }
                if (c == '}' && topC != '{') {
                    return false;
                }

            }
        }
        // 栈空有效（入栈元素都匹配出栈）
        return stack.isEmpty();
    }


    //  测试
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("[]"));
    }
}
