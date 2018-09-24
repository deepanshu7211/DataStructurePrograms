package com.deep.stack;

public class StackArrayMain {
	public static void main(String[] args) {
		StackArray stackArray = new StackArray();
		stackArray.push(1);
		stackArray.push(2);
		stackArray.push(3);
		stackArray.push(4);

		stackArray.pop();
		stackArray.pop();
		stackArray.pop();
		System.out.println(stackArray.peek());
	}
}

class StackArray {
	private int arr[] = new int[10];
	private int top = -1;

	public void push(int num) {
		if (top == arr.length - 1) {
			System.out.println("stackoverflow");
			return;
		}

		arr[++top] = num;
	}

	public void pop() {
		if (top == -1) {
			System.out.println("Stack underflow");
			return;
		}

		top--;

	}

	public int peek() {
		return arr[top];
	}
}