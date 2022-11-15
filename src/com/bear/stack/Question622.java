package com.bear.stack;

public class Question622 {
}
class MyCircularQueue {
	ListNode head;
	ListNode tail;
	int capacity;
	int size;
	public MyCircularQueue(int k) {
		this.capacity = k;
		size = 0;
	}

	public boolean enQueue(int value) {
		if (isFull()) {
			return false;
		}
		size++;
		ListNode tmp = new ListNode(value);
		if (isEmpty()) {
			head = tail = tmp;
		}else {
			tail.next = tmp;
			tail = tmp;
		}
		return true;
	}

	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}
		size--;
		head = head.next;
		return true;
	}

	public int Front() {
		if (isEmpty()) {
			return -1;
		}
		return head.val;
	}

	public int Rear() {
		if (isEmpty()) {
			return -1;
		}
		return tail.val;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return capacity == size;
	}
}