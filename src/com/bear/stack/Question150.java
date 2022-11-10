package com.bear.stack;


import java.util.ArrayDeque;

public class Question150 {

	public int evalRPN(String[] tokens) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (String token : tokens) {
			if (token.equals("+")) {
				Integer pop1 = stack.pop();
				Integer pop2 = stack.pop();
				stack.push(pop1+pop2);
			}else if (token.equals("-")) {
				Integer pop1 = stack.pop();
				Integer pop2 = stack.pop();
				stack.push(pop1-pop2);
			}else if (token.equals("*")) {
				Integer pop1 = stack.pop();
				Integer pop2 = stack.pop();
				stack.push(pop1*pop2);
			}else if (token.equals("/")) {
				Integer pop1 = stack.pop();
				Integer pop2 = stack.pop();
				stack.push(pop1/pop2);
			}else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

	public int evalRPN2(String[] tokens) {
		int len = tokens.length;
		int[] arrStack = new int[(len+1)/2];
		int index = -1;
		for (int i = 0; i < len; i++) {
			String tmp = tokens[i];
			switch (tmp){
				case "+":
					index--;
					arrStack[index] += arrStack[index+1];
					break;
				case "-":
					index--;
					arrStack[index] -= arrStack[index+1];
					break;
				case "*":
					index--;
					arrStack[index] *= arrStack[index+1];
					break;
				case "/":
					index--;
					arrStack[index] /= arrStack[index+1];
					break;
				default:
					arrStack[++index] = Integer.parseInt(tmp);
					break;
			}
		}
		return arrStack[index];
	}
}
