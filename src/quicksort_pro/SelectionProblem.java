package quicksort_pro;

import utils.Utils;

public class SelectionProblem {
	private SelectionProblem() {
	}

	// select the Nth object in the arr using quickSort
	public static <T extends Comparable<T>> void selection(T[] arr, int n) {

		quickSort(arr, 0, arr.length - 1, n - 1);

	}

	private static <T extends Comparable<T>> T quickSort(T[] arr, int l, int r, int n) {
		if (l == r) {
			return arr[l];
		}
		int p = partition(arr, l, r);
		if (p == n) {
			return arr[p];
		} else if (p < n) {
			return quickSort(arr, l, p - 1, n);
		} else {
			return quickSort(arr, l, p + 1, n);
		}
	}

	private static <T extends Comparable<T>> int partition(T[] arr, int l, int r) {
		Utils.swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
		T v = arr[l];
		int i = l + 1;// arr[l+1,i) <= v
		int j = r;// arr(j,r] >= v
		while (true) {
			while (l <= r && arr[i].compareTo(v) < 0) {
				i++;
			}
			while (j >= l + 1 && arr[j].compareTo(v) > 0) {
				j--;
			}
			if (i > j) {
				break;
			}
			Utils.swap(arr, i, j);
			i++;
			j--;
		}
		Utils.swap(arr, l, j);
		return j;
	}
}
