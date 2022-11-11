package com.bear.stack;

import java.util.ArrayDeque;
import java.util.HashSet;

public class Question402 {

	public String removeKdigits(String num, int k) {
		if (num.length() == k) {
			return "0";
		}
		ArrayDeque<Character> stack = new ArrayDeque<>();// 记录索引
		// 单调递增，遇到更小的记录下来，
		char[] chars = num.toCharArray();
		for (char aChar : chars) {
			while (k!=0 && !stack.isEmpty() && stack.peek() > aChar) {
				k--;
				stack.pop();
			}
			stack.push(aChar);
		}
		while (k != 0) {
			stack.pop();
			k--;
		}
		StringBuilder ret = new StringBuilder();
		boolean leadingZero = true;
		while (!stack.isEmpty()) {
			char digit = stack.pollFirst();
			if (leadingZero && digit == '0') {
				continue;
			}
			leadingZero = false;
			ret.append(digit);
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		Question402 question402 = new Question402();
		question402.removeKdigits("10200",1);
	}
}
