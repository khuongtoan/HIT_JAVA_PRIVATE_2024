package View;

import java.util.List;
import java.util.Scanner;

import Model.Account;
import Model.Address;
import Model.Role;
import Model.Status;
import Service.AccountServiceImpl;
import Service.AuthServiceImpl;

public class Main {
	static AccountServiceImpl accountService = new AccountServiceImpl();
	static AuthServiceImpl authService = new AuthServiceImpl();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			try {
				authService.login();
				while (authService.getCurrentUser() == null) {
					authService.login();
				}

				sc.nextLine();
				if (authService.getCurrentUser().getRole() == Role.ADMIN) {
					viewAdmin();
					System.out.println("---------------------\n Nhập vào lựa chọn của bạn: ");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						List dsa = accountService.getAllAccount();
						System.out.println("Danh sách tài khoản: ");
						for (var x : dsa) {
							System.out.println(x);
						}
						break;
					case 2:
						Account a = inputAccount();
						accountService.createNewAccount(a);
						break;
					case 3:
						String name = sc.nextLine();
						Account b = accountService.getAccountByUserName(name);
						if (b == null) {
							System.out.println("Không tìm thấy");
						} else {
							System.out.println(b);
						}
						break;
					case 4:
						String username1 = sc.nextLine();
						accountService.deleteAccount(username1);
						break;
					case 5:
						String username2 = sc.nextLine();
						System.out.println("Trạng thái muốn thay đổi (ACTIVE|BAN)");
						String st = sc.nextLine();
						Status status = null;
						if (st.equalsIgnoreCase("ACTIVE")) {
							status = Status.ACTIVE;
						} else if (st.equalsIgnoreCase("BAN")) {
							status = Status.BAN;
						}
						accountService.changeStatus(username2, status);
						break;
					case 0:
						authService.logout();
						break;
					default:
						System.out.println("sai");
					}
				} else {
					viewUser();
					System.out.println("---------------------\n Nhập vào lựa chọn của bạn: ");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Nhập vào mật khẩu cũ");
						String old = sc.nextLine();
						System.out.println("Nhập vào mật khẩu mới");
						String newpass = sc.nextLine();
						authService.ChangePassword(old, newpass);
					case 2:
						System.out.println("nhap vao ten muon in ra");
						String name2 = sc.nextLine();
						accountService.getAccountByUserName(name2);
						break;
					case 0:
						authService.logout();
					default:
						System.out.println("sai");

					}
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	static void viewUser() {
		System.out.println("------ HỆ THỐNG QUẢN LÝ TÀI KHOẢN ------");
		System.out.println("Xin chào Admin:" + authService.getCurrentUser().getUserName());
		System.out.println("Chọn một trong các chức năng sau: ");
		System.out.println("1.Xem danh sách Tài khoản" + "2.Tạo tài khoản mới" + "3.Tìm kiếm tài khoản theo username"
				+ "4.Xóa tài khoản" + "5.Thay Đổi trạng thái tài khoản(ACTIVE + BAN)" + "6.Xem thông tin cá nhân"
				+ "0.Đăng xuất!");
	}

	static void viewAdmin() {
		System.out.println("------ HỆ THỐNG NGƯỜI DÙNG ------");
		System.out.println("Xin chào User:" + authService.getCurrentUser().getUserName());
		System.out.println("Chọn một trong các chức năng sau: ");
		System.out.println("1.Đổi mật khẩu" + "2.Xem thông tin cá nhân" + "0.Đăng xuất!");
	}

	static Account inputAccount() {
		try {
			System.out.println("id = ");
			String id = sc.nextLine();

			System.out.println("Họ và Tên: ");
			String fullName = sc.nextLine();

			System.out.println("Tuổi: ");
			int age = sc.nextInt();
			sc.nextLine();

			System.out.println("Địa chỉ\nTên đường: ");
			String street = sc.nextLine();
			System.out.println("Thành phố: ");
			String city = sc.nextLine();
			Address address = new Address(street, city);

			System.out.println("Ngày, tháng, năm sinh: ");
			String birthday = sc.nextLine();
			System.out.println("Tên Đăng Nhập: ");
			String userName = sc.nextLine();

			System.out.println("Mật Khẩu: ");
			String password = sc.nextLine();

			System.out.println("1. AdDMIN\n2.USER");
			int check = sc.nextInt();
			sc.nextLine();
			Role role = null;
			if (check == 1) {
				role = Role.ADMIN;
			} else if (check == 2) {
				role = Role.USER;
			}

			Status s;
			s = Status.ACTIVE;
			System.out.println("Tạo tài khoản thành công!");

			return (new Account(id, fullName, age, address, birthday, userName, password, role, s));

		} catch (Exception e) {
			System.out.println("Lỗi khi nhập dữ liệu!");
		}
		return null;
	}
}
