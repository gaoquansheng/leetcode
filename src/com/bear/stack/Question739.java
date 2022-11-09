package com.bear.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

//[73,74,75,71,69,72,76,73]
//[1,1,4,2,1,1,0,0]
// 几天后温度会更高
public class Question739 {
	// 暴力解法：会超时。数据量太大了。
	// 相当于是跟之后的元素比较，每次都会重复比较很多次
	public int[] dailyTemperatures1(int[] temperatures) {
		int[] res = new int[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			for (int j = i+1; j < temperatures.length; j++) {
				if (temperatures[j] > temperatures[i]) {
					res[i] = j-i;
				}
			}
		}
		return res;
	}
	// 使用一个单调栈来存放温度的下标（可以回设答案）值，单调递减，
	// 如果遇到一个比栈顶元素更大的值，循环比较，设置栈顶索引的值为当前索引减去栈顶索引
	// 相当于跟之前的元素比较，只需要遍历一次。
	public int[] dailyTemperatures2(int[] temperatures) {
		int[] res = new int[temperatures.length];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
				Integer pop = stack.pop();
				res[pop] = i-pop;
			}
			stack.push(i);
		}
		return res;
	}


}
