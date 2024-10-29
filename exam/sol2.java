package buois3;

import java.util.Scanner;

public class sol2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		String res1 = "";
		String res2 = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				res2 += s.charAt(i);
			} else {
				res1 += s.charAt(i);
			}
		}

		System.out.println(res1);
		System.out.println(res2);
		sc.close();
	}
}
