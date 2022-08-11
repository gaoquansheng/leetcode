package com.bear.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 找到数组中消失的数字
 */
public class Question448 {

	/**
	 * 循环判断是否包含， 这种会超出时间限制
	 *
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 1; i <= nums.length; i++) {
			if (!collect.contains(i)) {
				res.add(i);
			}
		}
		return res;
	}

	/**
	 * 使用一个数组标记
	 *
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers2(int[] nums) {
		int[] tmp = new int[nums.length + 1];
		for (int num : nums) {
			tmp[num] = 1;
		}
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 1; i < tmp.length; i++) {
			if (tmp[i] == 0) {
				res.add(i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] tmp = {4,3,2,7,8,2,3,1};
		findDisappearedNumbers3(tmp);
	}
	/**
	 * 不使用额外的空间复杂度的话， 只能原地哈希
	 *
	 * @param nums
	 * @return
	 */
	public static List<Integer> findDisappearedNumbers3(int[] nums) {



		int len = nums.length;
		for (int num : nums) {
			int index = Math.abs(num)-1;
			nums[index] = -Math.abs(nums[index]);
		}
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				res.add(i+1);
			}
		}
		return res;
	}
}
