package baitapbuoi2_2;

import java.util.Scanner;

public class Bai2_SlidingWindow {

	public static long maxsum_sub(int[] a, int k) {
		int n = a.length;
		Long[] sumCurrent = new Long[n + 1];

		long res = Long.MIN_VALUE;
		sumCurrent[0] = 0L;

		for (int i = 0; i < n; i++) {
			sumCurrent[i + 1] = a[i] + sumCurrent[i];
		}

		for (int i = 0; i <= n - k; i++) {
			long CurrentS = sumCurrent[i + k] - sumCurrent[i];
			res = Math.max(res, CurrentS);

			for (int j = i + k; j < n; j++) {
				CurrentS += a[j];
				res = Math.max(res, CurrentS);
			}

		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Nhập số phần tử và số phần tử tối thiểu
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		int[] arr = new int[n]; // Khởi tạo mảng arr
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt(); // Nhập từng phần tử vào mảng arr
		}

		long result = maxsum_sub(arr, k);
		System.out.println(result);

		scanner.close();
	}
}
