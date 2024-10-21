package home_work_;

import java.util.Scanner;

public class bai2_tich {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();
		int result = 1;
		while (number > 0) {
			result *= number % 10;
			number /= 10;
		}
		System.out.println(result);
		sc.close();
	}
}
