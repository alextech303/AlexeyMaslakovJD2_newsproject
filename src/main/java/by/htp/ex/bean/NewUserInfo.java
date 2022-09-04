package by.htp.ex.bean;

public class NewUserInfo {
	private String login;
	private String password;
	private String email;

	public NewUserInfo() {
	}

	public NewUserInfo(String login, String password, String email) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		System.out.println("конструктор NewUserInfo1");
	}

	public NewUserInfo(String login, String password) {
		super();
		this.login = login;
		this.password = password;
		System.out.println("конструктор NewUserInfo2");
		
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	
}
