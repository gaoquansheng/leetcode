package com.bear.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

// 最短无序连续子数组
// [2,6,4,8,10,9,15] -> [6, 4, 8, 10, 9], 5
public class Question581 {

	// 排序加双指针，首先用一个新数组拷贝原数组值（或者索引）排序，然后前后双指针，分别指向前后第一个不相同的位置即可。
	public int findUnsortedSubarray(int[] nums) {
		int[] tmp = new int[nums.length];
		System.arraycopy(nums, 0, tmp, 0, nums.length);
		Arrays.sort(tmp);
		int left = -1;//指向前面第一个不同的位置，初始化为-1
		int right = nums.length;//指向后面第一个不同的位置，初始化为len
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != tmp[i]) {
				left = i;
				break;
			}
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] != tmp[i]) {
				right = i;
				break;
			}
		}
		return left == -1 ? 0 : right - left + 1;
	}

	// 一次遍历
	public static int findUnsortedSubarray2(int[] nums) {
		//初始化
		int len = nums.length;
		int min = nums[len - 1];
		int max = nums[0];
		int begin = 0, end = -1;
		//遍历
		for (int i = 0; i < len; i++) {
			if (nums[i] < max) {      //从左到右维持最大值，寻找右边界end
				end = i;
			} else {
				max = nums[i];
			}

			if (nums[len - i - 1] > min) {    //从右到左维持最小值，寻找左边界begin
				begin = len - i - 1;
			} else {
				min = nums[len - i - 1];
			}
		}
		return end - begin + 1;
	}

	// 使用两个单调栈来找左右边界
	public static int findUnsortedSubarray3(int[] nums) {
		ArrayDeque<Integer> leftStack = new ArrayDeque<>();// 单调递增维护最小的左边界
		ArrayDeque<Integer> rightStack = new ArrayDeque<>();// 单调递减维护最大的有边界
		int left = nums.length;
		int right = -1;
		for (int i = 0; i < nums.length; i++) {
			while (!leftStack.isEmpty() && nums[leftStack.peek()] > nums[i]) {
				left = Math.min(left,leftStack.pop());
			}
			leftStack.push(i);
			while (!rightStack.isEmpty() && nums[rightStack.peek()] < nums[nums.length - i - 1]) {
				right = Math.max(right,rightStack.pop());
			}
			rightStack.push(nums.length - i - 1);
		}
		return left == nums.length ? 0 : right - left + 1;
	}

	public static void main(String[] args) {
		findUnsortedSubarray3(new int[]{2,6,4,8,10,9,15});
	}


}
