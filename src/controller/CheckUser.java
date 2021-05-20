package controller;

public class CheckUser {

	public boolean isEqualPassword(String pass, String rpass) {
		if (pass.equals(rpass)) {
			return true;
		}
		return false;
	}

	public boolean isValidPassword(String pass) {
		if (pass.length() > 8) {
			return true;
		}
		return false;
	}

}
