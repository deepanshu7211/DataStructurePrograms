package com.deep.sorting;

import java.util.Arrays;

//Complexity O(nlogn)

public class QuickSort {
	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array " + Arrays.toString(arr));

		QuickSort quickSort = new QuickSort();
		quickSort.sort(arr, 0, arr.length - 1);

		System.out.println("Sorted Array :: " + Arrays.toString(arr));

	}

	private void sort(int arr[], int low, int high) {
		if (low < high) {
			int pIndex = partition(arr, low, high);
			sort(arr, low, pIndex - 1);
			sort(arr, pIndex + 1, high);
		}
	}

	private int partition(int[] arr, int low, int high) {

		int pivot = arr[high];
		int pIndex = low;

		for (int i = low; i <= high - 1; i++) {
			if (arr[i] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				pIndex = pIndex + 1;
			}
		}

		int temp = arr[pIndex];
		arr[pIndex] = arr[high];
		arr[high] = temp;
		return pIndex;
	}
}
