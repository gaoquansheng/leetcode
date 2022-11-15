package com.bear.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question456 {

	public boolean find132pattern(int[] nums) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		return false;
	}

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 1);
	}
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		ArrayList<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length-2; i++) {
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int tmp = nums[i];
			int left = i+1;
			int right = nums.length-1;
			while (left < right) {
				int sum = nums[left]+nums[right];
				if (sum+tmp == 0) {
					res.add(Arrays.asList(tmp,nums[left],nums[right]));
					left++;
					right--;
					while (left < right && nums[left] == nums[left-1]) {
						left++;
					}
					while (left<right && nums[right] == nums[right+1]){
						right--;
					}
				}else if (sum+tmp>0) {
					right--;
				}else {
					left++;
				}
			}
		}
		return res;
	}

}
