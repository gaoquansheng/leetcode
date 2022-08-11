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
	 * 原地哈希的精髓在于数组下标代表值， 数组值代表含义， 一般是取负数或者加偏移量， 都是为了不影响原本的值
	 *
	 * 值为1-n, 下标为0 - n-1， 注意每次修改值的时候要能够先恢复值,
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
