package buois3;

import java.util.Scanner;

public class sol4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long[] arr = new long[n + 1];
		arr[0] = 0;
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextLong();
			arr[i] += arr[i - 1];
		}
		int q = sc.nextInt();
		while (q-- > 0) {
			int L = sc.nextInt(), R = sc.nextInt();
			System.out.println(arr[R] - arr[L - 1]);
		}
	}
}
