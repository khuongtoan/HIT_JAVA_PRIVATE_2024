package Service;

import java.util.List;
import java.util.Scanner;

import Model.Account;
import Model.Status;

public class AccountServiceImpl implements AccountService {

	private AuthServiceImpl aS;
	static Scanner sc = new Scanner(System.in);

	public AccountServiceImpl() {
		aS = new AuthServiceImpl();
	}

	@Override
	public List<Account> getAllAccount() {
		return (List) aS.ds;
	}

	@Override
	public void createNewAccount(Account account) {
		aS.ds.add(account);
	}

	@Override
	public Account getAccountByUserName(String userName) {
		for (var x : aS.ds) {
			if (x.getUserName().equals(userName)) {
				return x;
			}
		}
		return null;
	}

	@Override
	public void deleteAccount(String userName) {
		for (int i = 0; i < aS.ds.size(); i++) {
			if (aS.ds.get(i).getUserName().equals(userName)) {
				aS.ds.remove(i);
				System.out.println("Xóa thành công!");
				return;
			}
		}
		System.out.println("Xóa thất bại!");
	}

	@Override
	public void changeStatus(String userName, Status status) {

		for (int i = 0; i < aS.ds.size(); i++) {
			if (aS.ds.get(i).getUserName().equals(userName)) {
				aS.ds.get(i).setStatus(status);
				;
				System.out.println("Thay đổi trạng thái thành công!");
				return;
			}
		}
		System.out.println("Thay đổi trạng thái thất bại!");
	}

}
