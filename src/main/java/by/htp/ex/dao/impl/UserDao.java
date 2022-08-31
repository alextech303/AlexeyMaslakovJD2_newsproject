package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.controller.impl.DoSignIn;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IUserDao;
import by.htp.ex.dao.poolConnection.ConnectionPool;
import by.htp.ex.dao.poolConnection.ConnectionPoolException;
import by.htp.ex.util.validation.UserDataValidation;
import by.htp.ex.util.validation.ValidationProvider;

public class UserDao implements IUserDao {

	private final static Logger LOG = LogManager.getLogger(by.htp.ex.dao.impl.UserDao.class);
	private final UserDataValidation validationUser = ValidationProvider.getInstance().getUserDataVelidation();
	private boolean checkUserlog = false;
	private boolean checkUserReg = false;
	@Override
	public boolean logination(String login, String password) throws DaoException {
		try {
			if (validationUser.checkAuthUser(login, password)) {

				checkUserlog = true;
			} else {
				LOG.info("Пользователь " + login + " не прошел логинацию!!!");
			}
		} catch (SQLException e) {

			LOG.error(e);
		}

		return checkUserlog;
	}

//		

	@Override
	public boolean registration(NewUserInfo user) throws DaoException, SQLException {

		if (validationUser.checkUserInBD(user.getLogin(), user.getEmail())) {
			checkUserReg = true;
			try (Connection connect = ConnectionPool.getInstance().takeConnection()) {

				String sql = "INSERT INTO users(login,password,email,dateOfRegistration,roles_id) VALUES(?,?,?,?,?)";
				PreparedStatement ps = connect.prepareStatement(sql);

				ps.setString(1, user.getLogin());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getEmail());
				ps.setObject(4, LocalDateTime.now());
				ps.setInt(5, 3);

				ps.executeUpdate();

			} catch (ConnectionPoolException e) {
				LOG.error("Пользователь не внесен в базу", e);
			}

		} else 
			return checkUserReg;
		
		return checkUserReg;
	}

	@Override
	public String getRole(String login) throws DaoException {

		return "ddd";

}
}
