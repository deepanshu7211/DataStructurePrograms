package com.deep.sorting;

import java.util.Arrays;

// Complexity O(nlogn)

public class MergeSort {
	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array " + Arrays.toString(arr));

		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(arr, 0, arr.length - 1);

		System.out.println("Sorted Array :: " + Arrays.toString(arr));

	}

	private void sort(int arr[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			sort(arr, low, mid);
			sort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	private void merge(int[] arr, int low, int mid, int high) {
		// TODO Auto-generated method stub
		int nL = mid - low + 1;
		int nR = high - mid;
		int L[] = new int[nL];
		int R[] = new int[nR];

		for (int i = 0; i < nL; i++) {
			L[i] = arr[low + i];
		}

		for (int j = 0; j < nR; j++) {
			R[j] = arr[mid + 1 + j];
		}

		int i = 0, j = 0, k = low;

		while (i < nL && j < nR) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < nL) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < nR) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}
