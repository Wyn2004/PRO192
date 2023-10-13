package module;

public class Login {

	Validator validator = new Validator();
	private final String userName = "thang";
	private String password = "qe180123";

	public Login() {
	}

	public Login(String password) {
		this.password = password;
	}

	public void inputInfo() {

		System.out.println("==================== WELCOME ====================");
		String inputUser = validator.inputUserName("Enter user name: ");
		String inputPass = validator.inputPassWord("Enter password: ");
		checkLogin(inputUser, inputPass);
		System.out.println();
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	private void checkLogin(String inputUser, String inputPass) {
		if (inputUser.equalsIgnoreCase(this.userName) && inputPass.equals(this.password)) {
			System.out.println("=================================================");
			System.out.println("Login succesfull!!!");
		} else {
			System.err.println("Error: Login failed, please try again!!!\n");
			inputInfo();
		}
	}

	public boolean checkPassWord(String inputPass) {
		if (inputPass.equals(this.password))
			return true;
		return false;
	}

	public void changePasword(String newPassWord) {
		this.password = newPassWord;
	}
}
