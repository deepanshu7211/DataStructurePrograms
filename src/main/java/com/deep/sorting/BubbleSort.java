package com.deep.sorting;

import java.util.Arrays;

//Complexity is O(n2)

public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = { 2, 7, 4, 1, 5, 3 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.println("Sorted Array :: " + Arrays.toString(arr));
	}
}
