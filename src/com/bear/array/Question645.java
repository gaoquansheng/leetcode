package com.bear.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 一个数字重复了， 找到重复的数字和丢失的数字
 */
public class Question645 {
	/**
	 * 因为只有1个数字重复了， 所以数学解法
	 * sum = 1+2+。。+n
	 * now = 1+2+i+i+(i+2)+..+n
	 * 对数组去重求和 total = 1+2+i+（i+2）+。。+n
	 * 所以重复的值等于now-total， 缺失的等于sum-total
	 * @param nums
	 * @return
	 */
	public int[] findErrorNums(int[] nums) {
		int len = nums.length;
		int sum = len*(len+1)/2;
		int[] tmp = new int[len+1];
		int now = 0;
		int total = 0;
		for (int num : nums) {
			now+=num;
			if (tmp[num] == 0) {
				total+=num;
				tmp[num] = 1;
			}
		}
		return new int[]{now-total, sum-total};
	}

	/**
	 * 哈希表计算， 重复的值出现了两次， 丢失的出现了0次
	 * @param nums
	 * @return
	 */
	public int[] findErrorNums2(int[] nums) {
		int len = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		int[] res = new int[2];
		for (int i = 1; i <= len; i++) {
			Integer count = map.getOrDefault(i, 0);
			if (count == 2) {
				res[0] = i;
			}else if (count == 0) {
				res[1] = i;
			}
		}
		return res;
	}
	}
