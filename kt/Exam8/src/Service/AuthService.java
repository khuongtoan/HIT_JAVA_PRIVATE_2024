package Service;

public interface AuthService {
	public void login();

	public void logout();

	public void ChangePassword(String oldPassword, String newPassword);
}
