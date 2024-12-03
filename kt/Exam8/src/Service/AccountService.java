package Service;

import java.util.List;

import Model.Account;
import Model.Status;

public interface AccountService {
	List<Account> getAllAccount();

	void createNewAccount(Account account);

	Account getAccountByUserName(String userName);

	void deleteAccount(String userName);

	void changeStatus(String userName, Status status);

}
