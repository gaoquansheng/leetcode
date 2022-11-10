package com.bear.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Question225 {
}
class MyStack {
	Queue<Integer> queue2;// 输出队列
	public MyStack() {
		queue2 = new ArrayDeque<>();
	}

	public void push(int x) {
		int n = queue2.size();
		queue2.offer(x);
		for (int i = 0; i < n; i++) {
			queue2.offer(queue2.poll());
		}
	}

	public int pop() {
		return queue2.poll();
	}

	public int top() {
		return queue2.peek();
	}

	public boolean empty() {
		return queue2.isEmpty();
	}
}
