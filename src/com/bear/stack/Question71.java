package com.bear.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Question71 {

	// 简化路径
	// /a/./b/../../c/ -> /c
	public String simplifyPath(String path) {
		ArrayDeque<String> stack = new ArrayDeque<>();
		String[] split = path.split("/");
		for (String s : split) {
			if (s.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}else if (s.length() > 0 && !".".equals(s)) {
				stack.push(s);
			}
		}
		if (stack.isEmpty()) {
			return "/";
		}
		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty()) {
			String pop = stack.pop();
			res.insert(0,"/"+pop);
		}
		return res.toString();
	}

	public String simplifyPath2(String path) {
		Deque<String> d = new ArrayDeque<>();
		int len = path.length();
		for (int i = 0; i < len; i++) {
			if (path.charAt(i) == '/') {
				continue;
			}
			int j = i;
			while (j < len && path.charAt(j) != '/') {
				j++;
			}
			String substring = path.substring(i, j);
			if (substring.equals("..")) {
				if (!d.isEmpty()) {
					d.pop();
				}
			}else if (!substring.equals(".")) {
				d.push(substring);
			}
			i = j;
		}
		StringBuilder sb = new StringBuilder();
		while (!d.isEmpty()) sb.insert(0,"/" + d.pollFirst());
		return sb.length() == 0 ? "/" : sb.toString();
	}

	public static void main(String[] args) {
		Question71 question71 = new Question71();
		question71.simplifyPath2("/home/bear//./../");
	}

}
