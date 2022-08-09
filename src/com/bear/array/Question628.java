package com.bear.array;

import java.util.Arrays;

/**
 * 三个数的最大乘积
 */
public class Question628 {

	/**
	 * 最大乘积只有两个可能性， 排序之后最大的三个正数， 最小的两个负数和最大的正数
	 * @param nums
	 * @return
	 */
	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		return Math.max(nums[len-1]*nums[len-2]*nums[len-3], nums[len-1]*nums[0]*nums[1]);
	}

	/**
	 * 因为上面使用了排序， 时间复杂度比较高， 那我们就使用一次遍历， 分别保留最大的三个值和最小的两个值
	 * 这种比较可能会有重复值， 不过无所谓
	 * @param nums
	 * @return
	 */
	public int maximumProduct2(int[] nums) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num > max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;
			}else if (num > max2) {
				max3 = max2;
				max2 = num;
			}else if (num > max3) {
				max3 = num;
			}
			if (num < min1) {
				min2 = min1;
				min1 = num;
			}else if (num < min2) {
				min2 = num;
			}
		}
		return Math.max(max1*max2*max3, min1*min2*max1);
	}
}
