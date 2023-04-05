package com.zyh.leetcode.editor.cn;//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics 数学 字符串 模拟 👍 702 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length();
        int p2 = num2.length();
        String num1Reverse = new StringBuilder(num1).reverse().toString();
        String num2Reverse = new StringBuilder(num2).reverse().toString();
        char[] charArray1 = num1Reverse.toCharArray();
        char[] charArray2 = num2Reverse.toCharArray();
        int flag = 0;//进位数
        StringBuilder sb = new StringBuilder();
        if (p1 > p2) {
            int i = 0;
            for (; i < p2; i++) {
                int a = Integer.parseInt(String.valueOf(charArray1[i]));
                int b = Integer.parseInt(String.valueOf(charArray2[i]));
                sb.append((a + b + flag) % 10);
                flag = (a + b + flag) / 10;
            }
            for (int j = i; j < p1; j++) {
                int a = Integer.parseInt(String.valueOf(charArray1[j]));
                sb.append((a + flag) % 10);
                flag = (a + flag) / 10;
            }
        } else {
            int i = 0;
            for (; i < p1; i++) {
                int a = Integer.parseInt(String.valueOf(charArray1[i]));
                int b = Integer.parseInt(String.valueOf(charArray2[i]));
                sb.append((a + b + flag) % 10);
                flag = (a + b + flag) / 10;
            }
            for (int j = i; j < p2; j++) {
                int a = Integer.parseInt(String.valueOf(charArray2[j]));
                sb.append((a + flag) % 10);
                flag = (a + flag) / 10;
            }
        }
        if (flag > 0) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addStrings("456", "12345");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
