package com.bear.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class Question496 {

	// 下一个更大的元素
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length];
		Arrays.fill(res, -1);
		// 维护nums2的一个单调递减栈，
		HashMap<Integer, Integer> map = new HashMap<>();// 值；index
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < nums2.length; i++) {
			while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
				Integer pop = stack.pop();
				map.put(nums2[pop],nums2[i]);
			}
			stack.push(i);
		}
		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i])) {
				res[i] = map.get(nums1[i]);
			}
		}
		return res;

	}
}
