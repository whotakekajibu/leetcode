package Utils;

public class SortUtils {

	public static void mergeSort(int[] arr) {
		helperMergeSort(arr, 0, arr.length - 1);
	}

	static void helperMergeSort(int[] arr, int start, int end) {
		if (end == start) {
			return;
		}
		int mid = (start + end) / 2;
		helperMergeSort(arr, start, mid);
		helperMergeSort(arr, mid + 1, end);
		mergeWithSentinel(arr, start, mid, end);
	}

	// 合并一个数组的两个有序部分（无哨兵）
	public static void mergeWithoutSentinel(int[] arr, int l, int m, int r) {
		int j = m + 1;
		int ol = l;
		int idx = 0;
		int[] helper = new int[r - l + 1];
		// System.arraycopy();
		while (l <= m && j <= r) {
			if (arr[l] > arr[j]) {
				helper[idx++] = arr[j++];
			} else {
				helper[idx++] = arr[l++];
			}
		}
		int index = 0;
		int bound = 0;
		if (l > m) {
			index = j;
			bound = r;
		} else if (j > r) {
			index = l;
			bound = m;
		}
		while (index <= bound) {
			helper[idx++] = arr[index++];
		}
		for (int i = 0; i < helper.length; i++) {
			arr[ol++] = helper[i];
		}
	}

	// 方法一：在过程中利用最大值作为哨兵值，来避免检查每个子序列是否为空
	// 一旦两个子序列都出现这个哨兵值，说明所有的值都已经合并，复制回数组a
	public static void mergeWithSentinel(int[] a, int from, int mid, int end) {
		// 左右数组，且每个数组长度+1，为了存放哨兵值
		int nl = mid - from + 1;
		int nr = end - mid;
		int[] left = new int[nl + 1];
		int[] right = new int[nr + 1];
		System.arraycopy(a, from, left, 0, nl);
		System.arraycopy(a, mid + 1, right, 0, nr);

		// 哨兵值
		left[nl] = Integer.MAX_VALUE;
		right[nr] = Integer.MAX_VALUE;

		int i = 0; // 控制左边数组
		int j = 0; // 控制右边数组
		// 从左右两个临时数组中各取一个数比较，将较小的一个数复制回数组
		for (int k = from; k <= end; k++) {
			if (left[i] <= right[j]) {
				// 哨兵值在这里得到体现，如果其中一个复制完，就会一直复制另外一个
				a[k] = left[i++];
			} else {
				a[k] = right[j++];
			}
		}
	}

	public static void quickSort(int[] arr) {
		quickSortHelper(arr, 0, arr.length - 1);
	}

	public static void quickSortHelper(int[] arr, int start, int end) {
		if (start >= end)
			return;
		int i = start, j = end;
		int pivot = arr[i];
		while (i < j) {
			while (i <= j) {
				if (arr[i] < pivot) {
					i++;
				}
			}
			while (arr[j] > pivot) {
				j--;
			}
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		int temp = arr[j];
		arr[j] = pivot;
		arr[start] = temp;
		quickSortHelper(arr, start, j);
		quickSortHelper(arr, i, end);
	}

	public static void quickSortHelperRefactor(int[] arr, int start, int end) {
		if (start >= end)
			return;
		int i = start, j = end;
		int pivot = arr[i];
		while (i < j) {
			while (i <= j) {
				if (arr[i] < pivot) {
					i++;
				}
			}
			while (arr[j] > pivot) {
				j--;
			}
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		int temp = arr[j];
		arr[j] = pivot;
		arr[start] = temp;
		quickSortHelper(arr, start, j);
		quickSortHelper(arr, i, end);
	}

	public int[] partion(int[] arr, int start, int end) {
		int less = start - 1, more = end + 1;
		int cur = start;
		return new int[] {};
	}

	public static boolean isTrue(int[] arr, int index, int sum, int target) {
		if (index == arr.length)
			return sum == target;
		System.out.println("现在尝试到了数组的第:" + index + "个数" + "现在累加到了" + sum);
		// if (sum == target) {
		// return true;
		// }
		return isTrue(arr, index + 1, arr[index] + sum, target) || isTrue(arr, index + 1, sum, target);
	}

	public static int binarySearch(int[] nums, int tar) {
		if (nums == null) {
			return -1;
		}
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == tar) {
				return mid;
			} else if (nums[mid] > tar) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 7, 9, 13, 16, 17, 45, 50, 51 };
		// System.out.println(isTrue(arr, 0, 0, 15));
		long a = 1;
		System.out.println((a << 32) - 1);
		// System.out.println(binarySearch(arr, 13));

	}
}
