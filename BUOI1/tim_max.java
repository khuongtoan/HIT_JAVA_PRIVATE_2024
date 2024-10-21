package home_work_;

import java.util.ArrayList;
import java.util.Scanner;

public class tim_max {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			arr.add(sc.nextInt());
		}

		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;

		for (int number : arr) {
			if (number >= max1) {
				max2 = max1;
				max1 = number;
			} else if (number > max2 && number < max1) {
				max2 = number;
			}
		}
		System.out.println(max2 + " " + max1);
		sc.close();
	}
}
