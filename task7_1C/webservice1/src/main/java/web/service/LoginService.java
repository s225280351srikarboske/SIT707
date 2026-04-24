package web.service;

public class LoginService {

	public static boolean login(String username, String password, String dob) {
		
		if (username == null || password == null || dob == null) {
			return false;
		}
		
		if (username.trim().isEmpty() || password.trim().isEmpty() || dob.trim().isEmpty()) {
			return false;
		}
		
		return "ahsan".equals(username)
				&& "ahsan_pass".equals(password)
				&& "1990-01-01".equals(dob);
	}
}