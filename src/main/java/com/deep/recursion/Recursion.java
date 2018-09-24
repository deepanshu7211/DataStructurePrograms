package com.deep.recursion;

public class Recursion {

	private int arr[] = new int[51];

	public static void main(String[] args) {
		Recursion recursion = new Recursion();
		int result = 0;
		result = recursion.factorial(5);
		System.out.println(" Result is :: " + result);
		recursion.fibonacci();
		for (int i = 0; i < recursion.arr.length; i++) {
			recursion.arr[i] = -1;
		}

		result = recursion.fibnoacciMemoization(10);
		System.out.println(" result :: " + result);
		result = recursion.pow(3, 3);
		System.out.println(" power result :: " + result);
	}

	private int factorial(int num) {
		if (num == 0) {
			return 1;
		} else {
			return num * factorial(num - 1);
		}
	}

	private void fibonacci() { // Recursion will lead to memory issue.
								// F(n) = F(n-1)+F(n-2)
		int num = 5;
		int first = 0, second = 1, third = 0;
		System.out.println(first);
		System.out.println(second);

		for (int i = 0; i < num; i++) {
			third = first + second;
			System.out.println(third);
			first = second;
			second = third;
		}

	}

	private int fibnoacciMemoization(int num) {
		if (num <= 1) {
			return num;
		}
		if (arr[num] != -1) {
			return arr[num];
		}
		arr[num] = fibnoacciMemoization(num - 1) + fibnoacciMemoization(num - 2);
		return arr[num];
	}

	private int pow(int x, int n) {
		if (n == 0) {
			return 1;
		} else {
			return x * pow(x, n - 1);
		}
	}
}
