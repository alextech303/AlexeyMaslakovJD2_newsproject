package by.htp.ex.dao;

import java.sql.SQLException;

import by.htp.ex.bean.NewUserInfo;

public interface IUserDao {
	
	
//	String signIn(String login, String password) throws DaoException;
	
	boolean logination(NewUserInfo user) throws DaoException, SQLException;
	
	boolean registration(NewUserInfo user) throws DaoException, SQLException;
	
	public String getRole(String login) throws DaoException, SQLException;
	

}
