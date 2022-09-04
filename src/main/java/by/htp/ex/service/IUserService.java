package by.htp.ex.service;

import java.sql.SQLException;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;

public interface IUserService {
	
	String signIn(NewUserInfo user) throws ServiceException;
	
	boolean registration(NewUserInfo user) throws ServiceException, DaoException, SQLException;

	

}
