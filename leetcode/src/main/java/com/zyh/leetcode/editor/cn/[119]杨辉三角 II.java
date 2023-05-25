//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//
// Related Topics 数组 动态规划 👍 491 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        //记录前一行数据
        List<Integer> before = null;
        //永远只保留最后一行
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> last = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j ==i){
                    last.add(1);
                }else {
                    int p = before.get(j - 1) + before.get(j);
                    last.add(p);
                }
            }
            //记录前一行数据
            before = last;
        }
        return before;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
