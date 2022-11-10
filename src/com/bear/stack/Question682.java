package com.bear.stack;

import java.util.ArrayDeque;

// 棒球比赛
public class Question682 {

	// "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
	//"D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
	//"C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
	public int calPoints(String[] operations) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int res = 0;
		for (String operation : operations) {
			if (operation.equals("C")) {
				stack.pop();
			}else if (operation.equals("D")) {
				stack.push(2*stack.peek());
			}else if (operation.equals("+")) {
				Integer pop = stack.pop();
				int sum = pop + stack.peek();
				stack.push(pop);
				stack.push(sum);
			}else {
				stack.push(Integer.parseInt(operation));
			}
		}
		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
	}
}
