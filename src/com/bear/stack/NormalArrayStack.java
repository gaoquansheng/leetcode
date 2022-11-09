package com.bear.stack;

public class NormalArrayStack {
	int maxSize;
	int[] arr;
	int top;
	public NormalArrayStack(int maxSize) {
		arr = new int[maxSize];
		this.maxSize = maxSize;
		top = -1;
	}
	// 入栈
	public void push(int data) {
		if (isFull()) {
			System.out.println("栈满了。不能继续添加");
		}else {
			arr[++top] = data;
		}
	}
	public boolean isFull() {
		return top == arr.length-1;
	}
	public boolean isEmpty() {
		return top == -1;
	}
	// 出栈
	public int pop() {
		if (isEmpty()) {
			System.out.println("栈空了，不能继续处元素");
			return -1;
		}else {
			return arr[top--];
		}
	}
	// 获取栈顶元素
	public int peek() {
		if (isEmpty()) {
			System.out.println("栈空了");
			return -1;
		}else {
			return arr[top];
		}
	}
}
