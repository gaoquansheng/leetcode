package com.bear.array;

/**
 * 最大连续1的个数， 数组中的数字不是1就是0
 */
public class Question485 {

    /**
     * 第一种解法，
     * 定义两个变量， 一个报错最终的结果， 另一个保存中间连续1的个数
     * 别忘记最后要比较一下
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes1(int[] nums) {

        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 0;
            }
        }
        return Math.max(res, count);
    }

    /**
     * 第二种解法， 使用类似滑动窗口的解法
     * 使用一个变量记录局部最后一个零的位置， 然后遍历计算
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes2(int[] nums) {
        int tmpIndex = -1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                tmpIndex = i;
            } else {
                res = Math.max(res, i - tmpIndex);
            }
        }
        return res;
    }

    /**
     * 双指针, left指向第一个1的位置， right指向第一个0的位置
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes3(int[] nums) {
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < nums.length) {
            while (right < nums.length && nums[right] == 1) {
                right++;
            }
            res = Math.max(res, right - left);
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            left = right;
        }
        return res;
    }
}