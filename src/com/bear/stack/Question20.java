package com.bear.stack;

import java.util.ArrayDeque;
import java.util.HashMap;

// 有效的括号
public class Question20 {

	// 思路1。遇到一个正括号，就把他的反括号入栈，使用Map存放正括号，反括号的对应关系，后面比较反括号
	public boolean isValid(String s) {
		if (s.length() % 2 != 0) {
			return false;
		}
		HashMap<Character, Character> map = new HashMap<>(){{
			put('(',')');
			put('[',']');
			put('{','}');
		}};
		ArrayDeque<Character> stack = new ArrayDeque<>();
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			if (map.containsKey(aChar)) {
				stack.push(map.get(aChar));
			}else {
				if (stack.isEmpty()|| stack.pop() != aChar) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	// 思路2。遇到一个正括号，直接入栈，使用一个Map存放反括号，和正括号的映射，后面比较正括号。
	public boolean isValid2(String s) {
		if (s.length() % 2 != 0) {
			return false;
		}
		char[] chars = s.toCharArray();
		HashMap<Character, Character> map = new HashMap<>(){{
			put(')','(');
			put(']','[');
			put('}','{');
		}};
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for (char aChar : chars) {
			if (map.containsKey(aChar)) {
				if (stack.isEmpty() || stack.peek() != map.get(aChar)) {
					return false;
				}
			}else {
				stack.push(aChar);
			}
		}
		return stack.isEmpty();
	}

}
