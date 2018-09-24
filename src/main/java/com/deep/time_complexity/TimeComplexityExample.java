package com.deep.time_complexity;

import java.util.Scanner;

public class TimeComplexityExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean flag = true;

		// First Approch
		for (int i = 2; i <= n - 1; i++) {
			if (n % i == 0) {
				System.out.println("Not prime ");
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("Number is Prime");
		}

		// Second Approach Checked till Square root of the Number
		boolean flag2 = true;
		int num = (int) Math.sqrt(n);
		for (int i = 2; i <= num; i++) {
			if (n % i == 0) {
				System.out.println("Not Prime");
				flag2 = false;
			}
		}
		if (flag2) {
			System.out.println("It is prime... ");
		}
	}
}
