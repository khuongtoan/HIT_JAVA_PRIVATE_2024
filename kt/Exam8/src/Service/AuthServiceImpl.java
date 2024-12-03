package Service;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Account;
import Model.Address;
import Model.Role;
import Model.Status;

public class AuthServiceImpl implements AuthService {

	public ArrayList<Account> ds = new ArrayList<>();
	private int position;
	private Account currentUser;
	static Scanner sc = new Scanner(System.in);

	public AuthServiceImpl() {
		ds.add(new Account("15a", "Khuong Xuan Toan", 20, new Address("Hàng Mã", "Hà Nội"), "30/11/2005", "toan123a",
				"chaoban1", Role.ADMIN, Status.ACTIVE));
		ds.add(new Account("15b", "Pham Minh Khuong", 20, new Address("Kim Bài", "Sơn la"), "1/11/2005", "khuong123a",
				"chaoban2", Role.USER, Status.ACTIVE));
		ds.add(new Account("1c", "Ly Quang Tung", 20, new Address("Thạch Thất", "Hà Nội"), "30/1/2005", "tung123a",
				"chaoban3", Role.USER, Status.BAN));
		currentUser = null;
	}

	public Account getCurrentUser() {
		return currentUser;
	}

	@Override
	public void login() {
		try {
			System.out.println("Tên Đăng Nhập:");
			String userName = sc.nextLine();
			System.out.println("Mật Khẩu");
			String passWord = sc.nextLine();

			for (int i = 0; i < ds.size(); i++) {
				if (ds.get(i).getUserName().equals(userName) && ds.get(i).getPassword().equals(passWord)) {
					currentUser = ds.get(i);
					position = i;
					System.out.println("Đăng nhập thành công!");
					return;
				}
			}
			System.out.println("Đăng nhập không thành công!");

		} catch (Exception e) {
			System.out.println("Dữ liệu nhập vào không hợp lệ");
		}
	}

	@Override
	public void logout() {
		System.out.println("đăng xuất thành công!");
		currentUser = null;
		position = -1;
	}

	@Override
	public void ChangePassword(String oldPassword, String newPassword) {
		try {
			System.out.println("Mật khẩu cũ: ");
			oldPassword = sc.nextLine();
			System.out.println("Mật Khẩu mới: ");
			newPassword = sc.nextLine();

			if (!ds.get(position).getPassword().equals(oldPassword)) {
				System.out.println("Mật khẩu cũ sai!");
				return;
			}

			ds.get(position).setPassword(newPassword);
			System.out.println("Cập nhật mật khẩu thành Công!");
		} catch (Exception e) {
			System.out.println("Dữ liệu nhập vào không hợp lệ!");
		}
	}

}
