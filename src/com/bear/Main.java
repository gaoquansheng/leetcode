package com.bear;

import com.bear.stack.NormalLinkedStack;

import java.security.KeyPair;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		int a = Integer.MAX_VALUE;
		long b = (long) a+1;
		System.out.println(b);
	}
	public boolean isIdealPermutation(int[] nums) {
		// 维持一个单调递增的单调栈，如果遇到一个元素比栈顶小，如果索引相差1为局部，其他为全局
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] > nums[j] && j-i>1) {
					return false;
				}
			}
		}
		return true;
	}
	public int[] intersect(int[] nums1, int[] nums2) {
		//
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		ArrayList<Integer> tmp = new ArrayList<>();
		int left1 = 0;
		int left2 = 0;
		while (left1 < nums1.length && left2 < nums2.length) {
			if (nums1[left1] == nums2[left2]) {
				tmp.add(nums1[left1]);
				left1++;
				left2++;
			}else if (nums1[left1] > nums2[left2]) {
				left2++;
			}else {
				left1++;
			}
		}
		int[] res = new int[tmp.size()];
		for (int i = 0; i < tmp.size(); i++) {
			res[i] = tmp.get(i);
		}
		return res;
	}



	public int search(int[] nums, int target) {
		int left = -1;
		int right = nums.length;
		while (left + 1 != right) {
			int mid = (left + right)/2;
			if (nums[mid] <= target) {
				left = mid;
			}else {
				right = mid;
			}
		}
		if (left == -1) {
			return -1;
		}
		return nums[left] == target?left:-1;
	}
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m-1;
		int p2 = n-1;
		int cur;
		while (p1 >= 0 || p2 >= 0) {
			if (p1 == -1) {
				cur = nums2[p2--];
			}else if (p2 == -1) {
				cur = nums1[p1--];
			}else if (nums1[p1] < nums2[p2]) {
				cur = nums1[p1--];
			}else {
				cur = nums2[p2--];
			}
			nums1[p1+p2+2] = cur;
		}
	}
	public int subtractProductAndSum(int n) {
		// 各位数字之积和各位数字之和
		int sum = 0;
		int tmp2 = 1;
		while (n > 0) {
			int tmp = n%10;
			n/=10;
			sum += tmp;
			tmp2*=tmp;
		}
		return tmp2-sum;
	}


}





