package com.bear.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 数组中重复的数据
 */
public class Question442 {

	/**
	 * 遍历使用hashset存
	 * @param nums
	 * @return
	 */
	public List<Integer> findDuplicates(int[] nums) {
		HashSet<Integer> integers = new HashSet<>();
		ArrayList<Integer> res = new ArrayList<>();
		for (int num : nums) {
			if (integers.contains(num)) {
				res.add(num);
			}else{
				integers.add(num);
			}
		}
		return res;
	}

	/**
	 * 原地哈希的精髓在于数组下标代表值， 数组值代表是否重复
	 * 值为1-n, 下标为0 - n-1
	 * @param nums
	 * @return
	 */
	public List<Integer> findDuplicates2(int[] nums) {
		ArrayList<Integer> res = new ArrayList<>();
		for (int num : nums) {
			num = Math.abs(num);
			if (nums[num-1] < 0) {
				res.add(num);
			}else {
				nums[num-1] = -nums[num-1];
			}
		}
		return res;
	}
}
