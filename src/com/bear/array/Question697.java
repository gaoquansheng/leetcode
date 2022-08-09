package com.bear.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组的度是指数组中任一元素出现频数最大值
 * 返回相同度的最小连续子数组
 */
public class Question697 {

	/**
	 * 首先遍历数组， 使用哈希表记录数组中的度, 开始位置和结束位置, 键是数组的元素，
	 * 然后遍历哈希表， 比较度， 更新长度
	 * @param nums
	 * @return
	 */
	public static int findShortestSubArray(int[] nums) {
		HashMap<Integer, int[]> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int[] ints = map.get(nums[i]);
				ints[0]++;
				ints[2] = i;
			}else{
				map.put(nums[i], new int[]{1, i, i});
			}
		}
		int res = 0;
		int count = 0;
		for (Map.Entry<Integer, int[]> integerEntry : map.entrySet()) {
			int[] value = integerEntry.getValue();
			if (value[0] > res) {
				res = value[0];
				count = value[2] - value[1]+1;
			}else if (value[0] == res) {
				count = Math.min(count, value[2]-value[1]+1);
			}
		}
		return count;
	}
}
