package buois3;

import java.util.Scanner;

public class applicationMAin {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Student a = new Student();
		a = nhap();
		a.display();
	}

	public static Student nhap() {
		System.out.print("Nhập mã sinh viên: ");
		String studentCode = scanner.next();
		System.out.print("Nhập họ và tên: ");
		String fullName = scanner.nextLine();
		System.out.print("Nhập tuổi: ");
		byte age = scanner.nextByte();
		scanner.nextLine();
		System.out.print("Nhập giới tính: ");
		String gender = scanner.nextLine();
		System.out.print("Nhập số điện thoại: ");
		String phoneNumber = scanner.nextLine();
		System.out.print("Nhập email: ");
		String email = scanner.nextLine();

		Student student = new Student(studentCode, fullName, age, gender, phoneNumber, email);

		return student;
	}

}