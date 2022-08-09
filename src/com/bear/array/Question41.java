package com.bear.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 缺失的第一个正数
 */
public class Question41 {

    /**
     * 将原本的数据放到哈希表中， 遍历即可， 但是不满足空间复杂度的要求
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            integers.add(num);
        }
        for (int i = 1; i <= len; i++) {
            if (!integers.contains(i)) {
                return i;
            }
        }
        return len + 1;
    }

    /**
     * 原地哈希
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = len+1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= len) {
                nums[num-1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        }
        return len+1;
    }
}
