package com.bear.stack;

import java.util.ArrayDeque;
// 最小栈
// 题目要求在实现栈的基础上，再保存当前栈的最小值，还需要在常数的时间复杂度内
// 我们很容易想到的是使用一个内置的栈来实现这个功能，然后使用一个变量来保存最小值，当弹出最小值当时候，再遍历找到最小值，但是这个时间复杂度是O(n)
// ！！ 归根到底是当我们的栈弹出最小值的时候，如果在O（1）的时间复杂度内找到之前的最小值
public class Question155 {

}
// 第一中解法：使用一个额外当空间来保存当前的最小值，比如辅助栈或者堆
// 第二中解法：栈中直接保存一个数组，数组的第一项为原值，第二项为最小值
// 第三种解法：直接修改栈的实现，Node节点保存当前值和最小值
// 第四中解法：观察两个数字之间的关系，差值（当前值和之前的最小值），最小值，原值，栈中保存当前值和最小值的差值，当差值是正数当时候，表明原值比最小值大，
// 弹出栈不影响最小值，当差值是负数的时候，表面当前值比之前的最小值小，最小值就是当前的，之前的最小值等于当前最小值减去负的差值即可。
class MinStack {
	ArrayDeque<int[]> stack;

	public MinStack() {
		stack = new ArrayDeque<>();
	}

	public void push(int val) {
		if (stack.isEmpty()) {
			stack.push(new int[]{val,val});
		}else {
			int[] peek = stack.peek();
			stack.push(new int[]{val,Math.min(val, peek[1])});
		}
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek()[0];
	}

	public int getMin() {
		return stack.peek()[1];
	}
}
// 第二种解法：题目的本质是当最小值出栈之后，之前当最小值怎么办？
class MinStack2 {
	ArrayDeque<Integer> stack;
	int min = Integer.MAX_VALUE;
	public MinStack2() {
		stack = new ArrayDeque<>();
	}

	public void push(int val) {
		if (val < min) {
			stack.push(min);
			min = val;
		}
		stack.push(val);

	}

	public void pop() {
		if (stack.pop() == min) {
			min = stack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}
}
class MinStack3 {
	ArrayDeque<Long> stack;
	long min;
	public MinStack3() {
		stack = new ArrayDeque<>();
	}

	public void push(int val) {
		if (stack.isEmpty()) {
			min = val;
			stack.push(0L);
		}else {
			min = Math.min(val,min);
			stack.push(val-min);
		}
	}

	public void pop() {
		if (stack.peek() < 0) {
			min -= stack.peek();
		}
		stack.pop();
	}

	public int top() {
		if (stack.peek() < 0) {
			return (int)min;
		}else {
			return (int)(stack.peek()+min);
		}
	}

	public int getMin() {
		return (int)min;
	}
}