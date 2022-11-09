package com.bear.stack;

import java.util.ArrayDeque;
import java.util.Stack;

// 字符串解码
public class Question394 {

    // "3[a2[c]]" -> accaccacc
    public String decodeString(String s) {
        // 一个数字栈，一个字符栈
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            }else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0,stack.pop());
                }
                String sub = sb.toString();
                stack.pop();// 弹出【
                StringBuilder tmp = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    tmp.insert(0,stack.pop());
                }
                int mul = Integer.parseInt(tmp.toString());
                while (mul > 0) {
                    for (char c1 : sub.toCharArray()) {
                        stack.push(c1);
                    }
                    mul--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0,stack.pop());
        }
        return res.toString();
    }

    public String decodeString2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int first = i;
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    i++;
                }
                String count = s.substring(first, i++);
                String sub = decodeString2(s.substring(i));
                stringBuilder.append(sub.repeat(Integer.parseInt(count)));
            } else if (s.charAt(i) == ']') {
                return stringBuilder.toString();
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Question394 question394 = new Question394();
        System.out.println(question394.decodeString2("3[a2[c]]"));
    }



}

