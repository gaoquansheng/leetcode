package com.bear.stack;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.TreeSet;

// 最长有效括号
public class Question32 {

	// "()(()"
//	public int longestValidParentheses(String s) {
//
//	}

	public int findLatestStep(int[] arr, int m) {
		TreeSet<Integer> set=new TreeSet<>();
		set.add(0);
		set.add(arr.length+1);
		if(arr.length==m) return arr.length;
		int n=arr.length;
		for (int i = n-1; i >=0; i--) {
			int index=arr[i];
			int a=set.lower(index);
			int b=set.higher(index);
			if(index-a-1==m||b-index-1==m){
				return i;
			}
			set.add(index);
		}
		return -1;
	}

	public static void main(String[] args) {
		Question32 question32 = new Question32();
		question32.findLatestStep(new int[]{3,5,1,2,4},1);
	}
}
