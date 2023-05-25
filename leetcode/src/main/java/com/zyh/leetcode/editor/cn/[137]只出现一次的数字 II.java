//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 你必须设计并实现线性时间复杂度的算法且不使用额外空间来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// Related Topics 位运算 数组 👍 1019 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) { // 因为nums[i]是32位整数， // 所以针对每一位的对应二进制数值求和
            int sum = 0;
            for (int num : nums) {
                sum += ((num >> i) & 1);//只算一位的和
                // 提取从右往左数第i位的数值，将所有nums[i] // 二进制下的第i位数值进行求和
            }
            if (sum % 3 == 1) { // 如果没办法被3整除，那么说明落单的那个数的第i位是1不是0
                res |= (1 << i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
