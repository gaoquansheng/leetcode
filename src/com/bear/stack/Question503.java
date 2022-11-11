package com.bear.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Question503 {

	// [5,4,3,2,1]
	// [-1,5,5,5,5]
	public int[] nextGreaterElements(int[] nums) {
		int[] res = new int[nums.length];
		Arrays.fill(res, -1);
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		// 从左到右一遍再从右到左一遍
		for (int i = 0; i < nums.length*2-1; i++) {
			int index = i%nums.length;
			while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
				Integer pop = stack.pop();
				res[pop] = nums[index];
			}
			stack.push(index);
		}
		return res;
	}

	public static void main(String[] args) {
		Question503 question503 = new Question503();
		question503.nextGreaterElements(new int[]{5,4,3,2,1});
	}
}
