package com.deep.sorting;

import java.util.Arrays;

//Complexity is O(n2)

public class SelectionSort {
	public static void main(String[] args) {
		int arr[] = { 2, 7, 4, 1, 5, 3 };
		int min = 0;
		for (int i = 0; i < arr.length; i++) {
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j; // updating the index of minimum element
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}

		System.out.println(Arrays.toString(arr));
	}
}
