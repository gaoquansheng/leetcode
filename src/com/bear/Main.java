package com.bear;

import com.bear.stack.NormalLinkedStack;

import java.security.KeyPair;
import java.util.*;

public class Main {
	public static void main(String[] args) {
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





