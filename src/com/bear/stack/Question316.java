package com.bear.stack;

import java.util.ArrayDeque;

public class Question316 {

	// 重复的留一个，并且字典序最小，并且不能打乱原有的顺序。
	// 从后向前，单调递减，
	// 三个要求 1。 去重 2。 不能打乱相对顺序 3。字典序最小
	// 如果遇到字典序更小的，如果后面还有相同的，就用后面的。单调递升
	// 用一个计数器计数
	public String removeDuplicateLetters(String s) {
		int[] countArr = new int[256];
		for (int i = 0; i < s.length(); i++) {
			countArr[s.charAt(i)]++;
		}
		boolean[] flgArr = new boolean[256];
		ArrayDeque<Character> stack = new ArrayDeque<>();
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			countArr[aChar]--;
			if (flgArr[aChar]) {
				continue;
			}
			while (!stack.isEmpty() && stack.peek() > aChar) {
				if (countArr[stack.peek()] == 0) {
					break;
				}
				flgArr[stack.pop()] = false;
			}
			stack.push(aChar);
		}
		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty()) {
			res.append(stack.pop());
		}
		return res.reverse().toString();
	}

	public static void main(String[] args) {
		Question316 question316 = new Question316();//"acdb"
		question316.removeDuplicateLetters("cbacdcbc");
	}
}
