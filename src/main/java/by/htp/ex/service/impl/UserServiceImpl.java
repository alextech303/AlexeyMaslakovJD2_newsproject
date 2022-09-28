package by.htp.ex.service.impl;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDao;
import by.htp.ex.dao.UserDataValidation;
import by.htp.ex.dao.ValidationProvider;
import by.htp.ex.dao.impl.UserDao;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.IUserService;

public class UserServiceImpl implements IUserService {
	private final static Logger LOG = LogManager.getLogger(by.htp.ex.service.impl.UserServiceImpl.class);

	private final IUserDao userDAO = DaoProvider.getInstance().getIUserDao();

	@Override
	public String signIn(NewUserInfo user) throws ServiceException {
		String roleOfUser = "guest";
		try {
			if (userDAO.logination(user))
				roleOfUser = userDAO.getRole(user.getLogin());

		} catch (DaoException | SQLException e) {
			LOG.error(e);
			throw new ServiceException(e);
		}
		return roleOfUser;
	}

	@Override
	public boolean registration(NewUserInfo user) throws DaoException, SQLException {
		boolean addUser = true;
		try {
			if (userDAO.registration(user)) {
				return addUser;
			} else {
				return !addUser;
			}

		} catch (DaoException | SQLException e) {
			LOG.error(e);
			throw new DaoException();
		}

	}
}
