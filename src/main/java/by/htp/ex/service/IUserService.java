package by.htp.ex.service;

import java.sql.SQLException;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;

public interface IUserService {
	
	String signIn(String login, String password) throws ServiceException;
	
	boolean registration(NewUserInfo user) throws ServiceException, DaoException, SQLException;

	boolean logination(String login, String password);

}
