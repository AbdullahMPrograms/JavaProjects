package com.MalikSort;
/**
 * Sorting algorithm for use in Sorting Analysis application
 * @author AbdullahPC
 *
 */
public class Sorts {
/**
 * Sorting Algorithm O(n^2) to effectively sort randomized data numerically as required in the program
 * @param value
 * @return
 */
	public static int[] selectionSort(int[] value) {
		for (int i = 0; i < value.length - 1; i++) {
			int k = i;
			for (int j = i + 1; j < value.length; j++) {
				if (value[j] < value[k]) {
					k = j;
				}
			}

			int smallNum = value[k];
			value[k] = value[i];
			value[i] = smallNum;
		}
		return value;
	}

}
