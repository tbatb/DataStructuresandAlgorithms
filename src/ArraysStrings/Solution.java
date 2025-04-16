package ArraysStrings;

public class Solution {


    /**
     * Write a function that reverses a string. The input string is given as an array of characters s.
     *
     * You must do this by modifying the input array in-place with O(1) extra memory.
     *
     *
     *
     * Example 1:
     *
     * Input: s = ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     * Example 2:
     *
     * Input: s = ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 105
     * s[i] is a printable ascii character.
     * @param s
     */
    public void reverseString(char[] s) {
        int n = s.length;
        for(int i = 0; i < s.length/2; i++){
            char tmp = s[i];
            s[i] = s[n-i-1];
            s[n - i - 1] = tmp;
        }
        return;
    }

    /**
     *
     * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
     *
     * Example 1:
     * Input: nums = [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     * Example 2:
     * Input: nums = [-7,-3,2,3,11]
     * Output: [4,9,9,49,121]*
     * Constraints:
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums is sorted in non-decreasing order.
     *
     *
     * @param nums
     * @return
     */

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }


}
