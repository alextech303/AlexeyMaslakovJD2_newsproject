package by.htp.ex.bean;

import java.io.Serializable;
import java.util.Objects;

public class NewUserInfo implements Serializable {

	private static final long serialVersionUID = 1L;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, login, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewUserInfo other = (NewUserInfo) obj;
		return Objects.equals(email, other.email) && Objects.equals(login, other.login)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "NewUserInfo [login=" + login + ", password=" + password + ", email=" + email + "]";
	}

}
