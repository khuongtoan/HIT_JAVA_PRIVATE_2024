package baitapbuoi2_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class search_index {
	public static int search(List<Integer> nums, int k) {
		int left = 0;
		int right = nums.size() - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums.get(mid) == k) {
				return mid;
			} else if (nums.get(mid) < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		List<Integer> a = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}

		int index = search_index.search(a, k);
		System.out.println(index);
		sc.close();
	}

}
