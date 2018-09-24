package com.deep.sorting;

import java.util.Arrays;
// Complexity is O(n2)

public class InsertionSort {
	public static void main(String[] args) {
		int arr[] = { 7, 2, 4, 1, 5, 3 };
		int index = 0, value = 0;
		for (int i = 1; i < arr.length; i++) {
			value = arr[i];
			index = i;
			while (index > 0 && arr[index - 1] > value) {
				arr[index] = arr[index - 1];
				index--;
			}
			arr[index] = value;
		}
		System.out.println("Instertion Sort Sorted Array :: " + Arrays.toString(arr));
	}
}
