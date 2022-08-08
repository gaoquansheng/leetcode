package com.bear.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * 返回数组中第三大的数字， 如果不存在则返回最大的数字, 其中数字有重复的情况
 */
public class Question414 {

    /**
     * 首先排序， 然后使用哈希表计数
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            set.add(nums[i]);
            if (set.size() == 3) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * 因为题目要求O(n)的时间复杂度， 所以排序被舍弃
     * 使用TreeSet保存结果, TreeSet有序， 可以指定排序规则
     *
     * @param nums
     * @return
     */
    public int thirdMax2(int[] nums) {
        TreeSet<Integer> integers = new TreeSet<>();
        for (int num : nums) {
            integers.add(num);
            if (integers.size() > 3) {
                integers.remove(integers.first());
            }
        }
        return integers.size() == 3 ? integers.first() : integers.last();
    }

    /**
     * 使用三个变量来分别保存最大值， 第二大和第三大的值
     *
     * @param nums
     * @return
     */
    public int thirdMax3(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
                // 因为这里存在重复值， 所以判断的时候要加上小于上面的区间
            }else if (num < first && num > second) {
                third = second;
                second = num;
            }else if (num < second && num > third) {
                third = num;
            }
        }
        return third == Long.MIN_VALUE?(int)first:(int)third;
    }

}
