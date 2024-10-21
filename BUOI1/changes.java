package home_work_;

import java.util.Scanner;

public class changes {
	public static String transform(int number, int co) {

		StringBuilder result = new StringBuilder();
		String digit = "0123456789ABCDEF";

		while (number != 0) {
			result.insert(0, digit.charAt(number % co));
			number /= co;

		}

		return result.length() > 0 ? result.toString() : "0";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int co = sc.nextInt();
		while (co < 2 && co > 16) {
			System.out.println("nhap lai he muon chuyen doi: ");
			co = sc.nextInt();
		}

		System.out.println(transform(number, co));
		sc.close();
	}

}
