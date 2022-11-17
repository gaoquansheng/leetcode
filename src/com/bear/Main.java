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
	public void rotate(int[] nums, int n) {
		boolean[] flag = new boolean[n];
		Arrays.fill(flag,true);
		for(int i = 2; i*i < n;i++) {
			if (flag[i]) {
				for(int j = i*i;j<n;j+=i) {
					flag[j] = false;
				}
			}
		}
	}
	public int countPrimes(int n) {
		boolean[] isPrim = new boolean[n];
		Arrays.fill(isPrim, true);
		// 从 2 开始枚举到 sqrt(n)。
		for (int i = 2; i * i < n; i++) {
			// 如果当前是素数
			if (isPrim[i]) {
				// 就把从 i*i 开始，i 的所有倍数都设置为 false。
				for (int j = i * i; j < n; j+=i) {
					isPrim[j] = false;
				}
			}
		}

		// 计数
		int cnt = 0;
		for (int i = 2; i < n; i++) {
			if (isPrim[i]) {
				cnt++;
			}
		}
		return cnt;
	}
	public void reverse(int[] nums, int left, int right) {
		while (left < right) {
			int tmp = nums[left];
			nums[left++] = nums[right];
			nums[right++] = tmp;
		}
	}
	public int numMatchingSubseq(String s, String[] words) {
		// 1。 个数 《= s
		// 2. 前后位置
		int res = 0;
		char[] chars = s.toCharArray();
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word,map.getOrDefault(word,0)+1);
		}
		Set<String> strings = map.keySet();
		for (String word : strings) {
			int index = 0;//指向word的下一个等待确认的位置
			if (word.length() > s.length()) {
				continue;
			}
			for (char aChar : chars) {
				if (index == word.length()) {
					break;
				}
				if (aChar == word.charAt(index)) {
					index++;
				}
			}
			if (index == word.length()) {
				res+=map.get(word);
			}
		}
		return res;
	}

}





