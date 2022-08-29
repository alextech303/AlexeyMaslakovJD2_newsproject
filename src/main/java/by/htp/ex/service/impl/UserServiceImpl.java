package by.htp.ex.service.impl;

import java.sql.SQLException;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDao;
import by.htp.ex.dao.impl.UserDao;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.IUserService;
import by.htp.ex.util.validation.UserDataValidation;
import by.htp.ex.util.validation.ValidationProvider;

public class UserServiceImpl implements IUserService {

	private final IUserDao userDAO = DaoProvider.getInstance().getIUserDao();

	private boolean addUser = true;
	
	private String roleOfUser="guest";

	@Override
	public String signIn(String login, String password) throws ServiceException {

		try {
			if (userDAO.logination(login, password)) 
				roleOfUser = userDAO.getRole(login);
			

		} catch (DaoException | SQLException e) {
			throw new ServiceException(e);
		}
return roleOfUser;
	}

	@Override
	public boolean registration(NewUserInfo user) throws DaoException, SQLException {

		if (userDAO.registration(user)) {
			return addUser;
		} else {
			return !addUser;
		}

	}

	@Override
	public boolean logination(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
