package com.bear.stack;

public class NormalLinkedStack {
	Node dummy;// 头节点，如果使用头节点指向栈顶

	public NormalLinkedStack() {
		dummy = new Node(-1,null);
	}

	public void push(int data) {
		dummy.next = new Node(data, dummy.next);
	}
	public int pop() {
		if (isEmpty()) {
			System.out.println("栈为空");
			return -1;
		}else {
			int val = dummy.next.data;
			dummy.next = dummy.next.next;
			return val;
		}
	}
	public boolean isEmpty() {
		return dummy.next == null;
	}
	public int peek() {
		if (isEmpty()) {
			System.out.println("栈为空");
			return -1;
		}else {
			return dummy.next.data;
		}
	}

}
class Node {
	int data;
	Node next;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}
