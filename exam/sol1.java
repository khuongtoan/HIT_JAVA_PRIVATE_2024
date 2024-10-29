package buois3;

import java.util.Scanner;

public class sol1 {

	public static String[] doc = { "mươi ", "một ", "hai ", "ba ", "bốn ", "năm ", "sáu ", "bảy ", "tám ", "chín ",
			"linh ", "trăm ", };

	public static String so1(int x) {
		if (x == 0) {
			return "";
		}
		return doc[x];
	}

	public static String so2(int x) {
		if (x == 0) {
			return doc[0];
		}

		return doc[x] + doc[0];
	}

	public static String so3(int x) {
		if (x == 0) {
			return "";
		}
		return doc[x] + doc[11];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int one = n % 10;
		int two = (n % 100) / 10;
		int three = n % 100;
		System.out.println(so3(three) + so2(two) + so1(one));

	}

}
