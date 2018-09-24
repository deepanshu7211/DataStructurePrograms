package com.deep.binary_search;

public class BinarySearch {

	private int arr[] = { 2, 6, 13, 21, 36, 47, 63, 81, 97 };
	private int arr2[] = { 2, 6, 10, 10, 10, 18, 20 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		int index = 0;
		/*
		 * index = binarySearch.binarySearch(63);
		 * 
		 * index = binarySearch.binarySearchRecursive(0, binarySearch.arr.length
		 * - 1, 47);
		 * 
		 * System.out.println(" Index of an Element :: " + index +
		 * " arraylnegth :: " + binarySearch.arr.length);
		 * 
		 * index = binarySearch.binarySearchFirstOccurence(10);
		 * 
		 * System.out.println(" Index of an Element :: " + index +
		 * " arraylnegth :: " + binarySearch.arr2.length);
		 */

		/*
		 * Find First and last occurence of a number to find out the count of
		 * the number in an array.
		 */

		int first = binarySearch.findCountOccurenceOfNumber(10, true);
		int last = binarySearch.findCountOccurenceOfNumber(10, false);
		System.out.println(" Occurrence of Number " + (last - first + 1));
		// binarySearch.findRotationCount();
		binarySearch.findElementInCircularSortedArray();
	}

	private int binarySearch(int num) {
		int first = 0, last = arr.length - 1;
		int mid = 0;
		while (first <= last) {
			mid = first + (last - first) / 2;
			if (arr[mid] == num) {
				return mid;
			} else if (num < arr[mid]) {
				last = mid - 1;
			} else {
				first = mid + 1;
			}
		}
		return -1;

	}

	private int binarySearchRecursive(int first, int last, int num) {
		if (first > last) {
			return -1;
		}
		int mid = first + (last - first) / 2;
		if (num == arr[mid])
			return mid;
		else if (num < arr[mid]) {
			return binarySearchRecursive(first, mid - 1, num);
		} else {
			return binarySearchRecursive(mid + 1, last, num);
		}
	}

	private int binarySearchFirstOccurence(int num) {
		int first = 0, last = arr2.length - 1, result = -1;
		while (first <= last) {
			int mid = first + (last - first) / 2;
			if (num == arr2[mid]) {
				result = mid;
				last = mid - 1; // For Last Occurrence first= mid+1
			} else if (num < arr2[mid]) {
				last = mid - 1;
			} else {
				first = mid + 1;
			}
		}
		return result;
	}

	private int findCountOccurenceOfNumber(int num, boolean firstFlag) {
		int first = 0, last = arr2.length - 1, result = -1;

		while (first <= last) {
			int mid = first + (last - first) / 2;
			if (num == arr2[mid]) {
				result = mid;
				if (firstFlag) {
					last = mid - 1;
				} else {
					first = mid + 1;
				}
			} else if (num < arr2[mid]) {
				last = mid - 1;
			} else {
				first = mid + 1;
			}
		}

		return result;

	}

	private void findRotationCount() { // Find Index of Lowest Element To know
										// the no. of rotation. We can use
										// binary search also
		int rot[] = { 11, 12, 15, 18, 2, 5, 6, 8 };
		int min = Integer.MAX_VALUE, minIndex = -1;
		for (int i = 0; i < rot.length; i++) {
			if (rot[i] < min) {
				min = rot[i];
				minIndex = i;
			}
		}
		System.out.println(" Rotation Count :: " + minIndex);
	}

	/**
	 * 
	 */
	private void findElementInCircularSortedArray() {
		int a[] = { 11, 12, 15, 18, 2, 5, 6, 8 };
		int x = 12;
		int low = 0, high = a.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (x == a[mid]) { // Case 1 Found Middle element
				System.out.println(" Index of element :: " + mid);
				break;
			} else if (a[mid] <= a[high]) { // Case 2 : Right Side array is
											// sorted Check on right side
				if (x > a[mid] && x <= a[high]) {
					low = mid + 1; // Element on Right side.
				} else {
					high = mid - 1;
				}
			} else {
				if (x >= a[low] && x < a[mid]) {
					high = mid - 1; // Element on Left hand Side
				} else {
					low = mid + 1;
				}
			}
		}

	}
}
