package com.bear.stack;

public class Question641 {
}

class MyCircularDeque {
	int[] arr;
	int capacity;
	int head;
	int tail;

	public MyCircularDeque(int k) {
		capacity = k+1;
		arr = new int[capacity];
		head = tail = 0;
	}

	public boolean insertFront(int value) {
		if (isFull()) {
			return false;
		}
		int index = (head-1+capacity)%capacity;
		head = index;
		arr[index] = value;
		return true;
	}

	public boolean insertLast(int value) {
		if (isFull()) {
			return false;
		}
		arr[tail] = value;
		tail = (tail+1)%capacity;
		return true;
	}

	public boolean deleteFront() {
		if (isEmpty()) {
			return false;
		}
		head = (head+1)%capacity;
		return true;
	}

	public boolean deleteLast() {
		if (isEmpty()) {
			return false;
		}
		tail = (tail+capacity-1)%capacity;
		return true;
	}

	public int getFront() {
		if (isEmpty()) {
			return -1;
		}
		return arr[head];
	}

	public int getRear() {
		if (isEmpty()) {
			return -1;
		}
		int index = (tail+capacity-1)%capacity;
		return arr[index];
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public boolean isFull() {
		return (tail+1)%capacity == head;
	}
}
